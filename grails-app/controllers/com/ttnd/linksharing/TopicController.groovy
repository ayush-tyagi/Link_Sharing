package com.ttnd.linksharing

//import CO.ResourceSearchCo
import com.ttnd.linksharing.co.ResourceSearchCo
import com.ttnd.linksharing.co.SearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
import enums.L_Visibility
import grails.converters.JSON

//import grails.validation.Validateable

class TopicController {

    def topicService

    def index() {
        render "hello index"
    }

    /*def invite(Long id,String email_id){
        Topic topic = Topic.get(id)
        if(topic){

        }else{
            flash.error = "Topic not found"
        }
    }*/

    def show(ResourceSearchCo co) {
        Topic topic = Topic.read(co.topicId)
        if (topic) {
            if (topic.visibility == L_Visibility.PUBLIC) {
                User user = session.user
                List<Topic> subscribedTopics = User.getSubscribedTopics(user)
                render(view: "topicShow", model: [subscribedUsers: topic.subscribedUsers, topic: topic, subscribedTopics: subscribedTopics])
            } else if (topic.visibility == L_Visibility.PRIVATE) {
                User user = session.user
                Subscription subscription = Subscription.findByTopicAndUser(topic, user)
                if (subscription) {
                    render("Success")
                } else {
                    flash.error = "Not a Subscribed User"
                    redirect(controller: "login ", action: "index")
                }
            }
        } else {
            flash.error = "Topic does not exist"
            redirect(controller: 'login', action: 'index')
        }
    }

    def creatorTopics() {
        User user = session.user
        List<Topic> topics = Topic.findAllByCreatedBy(user,[sort:'lastUpdated',order:'desc'])
        render(view: '/topic/creatorTopic', model: [topics: topics])
    }

    def searchTopic(SearchCo searchCo) {
//         println "________________________>>>>hit  ${searchCo.q }"
        User user = session.user
//         println "--------------->>>>${user}"
        if (user) {
            List<ReadingItem> readingItems = ReadingItem.createCriteria().list() {
                'resource' {
                    'topic' {
                        like('name', "%${searchCo.q}%")
                    }
                }
            }
//             println "--------------->>>>inside if"
//             List<Topic> topics = Topic.findAllByNameIlike("%${searchCo.q}%")
//             println  "--------------->>>>inside if ${topics}"
            render(view: '/readingItem/_readingItemsInbox', model: [readingItems: readingItems])
        } else {
            render([message: "Not Found"] as JSON)
        }
    }

    def save(String topicName, String visibility) {
        log.info topicName
        log.info visibility
        User user = session.user
        log.info user
        Topic topic = new Topic(name: topicName, createdBy: user, visibility: L_Visibility.valueOf(visibility))
        if (topic.validate()) {
            topic.save(flush: true)
            Subscription subscription = new Subscription(user: user,topic:topic )
            subscription.save(flush: true)

            List<User> users = User.list()
            users.each{ useri ->
                useri.addToReadingItems(isRead: false,user: user)
            }


            flash.message = "Success"
            render "Success"
        } else {
            flash.error = "Error on topic"
            render flash.error
            log.error("${topic.errors.allErrors}")
        }
    }

    def show1() {
        List<TopicVo> list = Topic.getTrendingTopics()
        render "${list}"
    }

    def userPost(Long id) {
//        println "----------*******************${id}"
        User user = session.user
        Resource resource = Resource.findById(id)
        int score = user.getScore(resource.id)
//        println "-+-+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_${resource.properties}"
        render view: '/resource/resourceShow', model: [resource: resource, score: score]
    }

    def update(Long id, String visibility) {
        Topic topic = Topic.get(id)
//        println "--------------------->>>>>>>${params}"
        topic.visibility = L_Visibility.changeStringInVisibility(visibility)
//        println "==================>>>>${topic.visibility}"
        if (topic.validate()) {
            println "----------------->>>>inside validate"
            topic.save(flush: true)
            render([message: "SuccessFul "] as JSON)
        } else {
            render([message: "Sorry "] as JSON)
        }
    }

    def delete(Long id) {
        Topic topic = Topic.get(id)
        User user = session.user
        if (topic.createdBy != user) {
            topic.delete(flush: true)
            render([message: "Successfully deleted"] as JSON)
        } else {
            render([message: "Creator is not allowed to delete Topic"] as JSON)
        }
    }

    def changeTopicName(String topicName, Long id) {
        println "=====>>>${topicName}========>>>>${id}"
        if (topicService.changeTopicName(topicName,id)) {
//            flash.message="abc"
//            render(view: 'user/profile')
            User user = session.user
            List<Topic> subscribedTopics = User.getSubscribedTopics(user)
            render(template: "/user/createdTopicsOfUser" ,model: [subscribedTopics: subscribedTopics,user:user])

        } else {
            render([error: "Oops something went wrong "] as JSON)
        }
    }

    def invite(String topicName, String email) {
        if (topicName && email) {
            Topic topic =Topic.findByName(topicName)
            if (topicService.invite(topic.name, email)) {
                flash.message = "Invitation Sent"
            } else {
                flash.error = "Invitation not Sent"
            }
        }
        redirect(controller: 'login', action: 'index')
    }

    def join(Long id) {
        Topic topic = Topic.get(id)
        if (topic) {
            if (session.user) {
                if (topicService.joinTopic(topic, session.user)) {
                    flash.message = "Topic Subscribed"
                } else {
                    flash.error = "Topic not Subscribed"
                }
            } else {
                flash.error = "Session not set"
            }
        } else {
            flash.error = "Topic do not exists"
        }
        redirect(controller: "login", action: "index")
    }
}
