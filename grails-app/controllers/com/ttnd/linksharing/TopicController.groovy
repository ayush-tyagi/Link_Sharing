package com.ttnd.linksharing

//import CO.ResourceSearchCo
import com.ttnd.linksharing.co.ResourceSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
import enums.L_Visibility

class TopicController {

    def index() { }

    def show(ResourceSearchCo co){
        Topic topic = Topic.read(co.topicId)

        if(topic){
            if(topic.visibility== L_Visibility.PUBLIC){
                User user = session.user
                List subscribedTopics = User.getSubscribedTopics(user)
                render(view: "topicShow",model: [subscribedUsers:topic.subscribedUsers,topic:topic,subscribedTopics:subscribedTopics])
            }else if(topic.visibility== L_Visibility.PRIVATE){
                User user = session.user
             Subscription subscription = Subscription.findByTopicAndUser(topic,user)
                if(subscription){
                    render("Success")
                }else{
                    flash.error="Not a Subscribed User"
                    redirect(controller:"login " ,action:"index")
                }
            }
        }else{
            flash.error="Topic does not exist"
        redirect(controller:'login' ,action:'index' )
        }
    }


    def save(String topicName,String visibility){
        log.info topicName
        log.info visibility
        User user = session.user
        log.info user
        Topic topic=new Topic(name:topicName,createdBy: user,visibility: L_Visibility.valueOf(visibility))
        if(topic.validate()){
            topic.save(flush: true)
            flash.message ="Success"
            render "Success"
        }else {
            flash.error = "Error on topic"
            render flash.error
            log.error("${topic.errors.allErrors}")
        }
    }

    def show1(){
        List<TopicVo> list = Topic.getTrendingTopics()
        render "${list}"
    }

    def userPost(Long id){
//        println "----------*******************${id}"
        User user = session.user
        Resource resource = Resource.findById(id)
        int score = user.getScore(resource.id)
        println "-+-+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_${resource}"
        render view:'/resource/resourceShow',model: [resource:resource,score:score]
    }
}
