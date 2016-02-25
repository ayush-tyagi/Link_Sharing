package com.ttnd.linksharing

import CO.ResourceSearchCo
import com.ttnd.linksharing.co.ResourceSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
import enums.L_Visibility
import enums.Seriousness

class TopicController {

    def index() { }

    def show(long id, ResourceSearchCo co){
        Topic topic = Topic.read(id)

        if(topic){
            if(topic.visibility== L_Visibility.PUBLIC){
                render("Success")
            }else if(topic.visibility== L_Visibility.PRIVATE){
                User user = session["user"]
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

    def save(Topic topic,String seriousness){
        User user = session["user"]
        Seriousness seriousness1 = Seriousness.changeStringInSeriousness(seriousness)
        if(topic.validate()){
            topic.save(flush: true)
            flash.message ="Success"
            render"Success"
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
}
