package com.ttnd.linksharing

//import CO.ResourceSearchCo
import com.ttnd.linksharing.co.ResourceSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
import enums.L_Visibility
import grails.converters.JSON
import grails.validation.Validateable

class TopicController {

    def index() {}

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


    def save(String topicName, String visibility) {
        log.info topicName
        log.info visibility
        User user = session.user
        log.info user
        Topic topic = new Topic(name: topicName, createdBy: user, visibility: L_Visibility.valueOf(visibility))
        if (topic.validate()) {
            topic.save(flush: true)
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
//       println "==============>>>>>>>${id} -------------->>>>>>${topicName}"
        Topic topic = Topic.get(id)
//       println "----------------->>>>>>>>>>${topic}"
        if (Topic.executeUpdate("update Topic as t set t.name=:name where t.id=${topic.id}", [name: topicName])) {
            render([message: "changed succesfully "] as JSON)
        } else {
            render([message: "Oops something went wrong "] as JSON)
        }
    }
}
