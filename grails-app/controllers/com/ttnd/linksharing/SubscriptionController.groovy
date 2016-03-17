package com.ttnd.linksharing

import enums.Seriousness
import grails.converters.JSON

class SubscriptionController {

    def index() {
        render "hello index"
    }

    def save(Long topicId) {
        Topic topic = Topic.get(topicId)
        User user = session.user
        Subscription subscription = new Subscription(topic: topic, user: user)
        if (subscription.validate()) {
            subscription.save(flush: true)
//            flash.message = "Saved successfully"
//            render([message: "Saved successfull"] as JSON)
// redirect(controller: "user",action: "index")
            render(template: '/subscription/normalUser' ,model: [topicId:topic.id ])
        } else {
            flash.error = "Unsuccessful to save"
//            render "${subscription.errors.allErrors}"
            render([error: "Saved Unsuccessfull"] as JSON)
        }
    }

    def update(Long id, String seriousness) {                           //,Seriousness seriousness
        if (id) {
            Subscription subscription = Subscription.get(id)
            if (subscription) {
                subscription.seriousness = Seriousness.changeStringInSeriousness(seriousness)
                if (subscription.validate()) {
                    subscription.save(flush: true)
                    render([message: 'Successfully changed'] as JSON)
                } else {
                    render([error: 'Fail to update'] as JSON)
                }
            } else {
                render([error: 'Subscription does not exists'] as JSON)
            }
        }
    }

    def delete(Long topicId) {
        Topic topic = Topic.get(topicId)
        User user = session.user
        Subscription subscription = Subscription.findByTopicAndUser(topic, user)
        if (subscription) {
            if (!user.equalSessionUser(topicId)) {
                subscription.delete(flush: true)
                List<Topic> subscribedTopics = User.getSubscribedTopics(user)
                render(template: '/subscription/subscribedTopics', model: [subscribedTopics: subscribedTopics])
//                render([message :"Delete successfull",status:true] as JSON)
//            flash.message ="Deleted Successfully"
//            redirect(controller: "user" ,action:"index" )
            } else {
                render([error: "Creator of topic cannot delete subscription"] as JSON)
            }
        } else {
//            flash.error = "Not Deleted"
//            render "User not Found  "
            render([error: "Subscription does not exists anymore . . ."] as JSON)
        }
    }
}
