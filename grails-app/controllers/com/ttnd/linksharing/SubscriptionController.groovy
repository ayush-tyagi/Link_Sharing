package com.ttnd.linksharing

import enums.Seriousness

class SubscriptionController {

    def index() {}

    def save(Long topicId) {
        Topic topic = Topic.get(topicId)
        User user = session.user
        Subscription subscription = new Subscription(topic: topic, user: user)
        if (subscription.validate()) {
            subscription.save(flush: true)
            flash.message = "Saved successfully"
            redirect(controller: "user",action: "index")
        }else{
            flash.error = "Unsuccessful to save"
            render "${subscription.errors.allErrors}"
        }
    }

    /*def update(Long id){                           //,Seriousness seriousness
        if(id){
            Topic topic = Topic.get(id)
            User user = session["user"]
            Subscription subscription = new Subscription(topic:topic,user:user)

            if(subscription.validate()){
                subscription.save()
                render "Success"
            }else{
                render "${subscription.errors.allErrors}"
            }

        }
    }*/

    def delete(Long topicId) {
        Topic topic=Topic.get(topicId)
        User user = session.user
        Subscription subscription = Subscription.findByTopicAndUser(topic,user)
        if (subscription) {
            subscription.delete(flush: true)
            flash.message ="Deleted Successfully"
            redirect(controller: "user" ,action:"index" )
        } else {
            flash.error = "Not Deleted"
            render "User not Found  "
        }
    }
}
