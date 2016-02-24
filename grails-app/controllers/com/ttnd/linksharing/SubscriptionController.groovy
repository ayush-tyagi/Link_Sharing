package com.ttnd.linksharing

import enums.Seriousness

class SubscriptionController {

    def index() {}

    def save(Long id) {
        Topic topic = Topic.get(id)
        User user = session["user"]
        Subscription subscription = new Subscription(topic: topic, user: user)
        if (subscription.validate()) {
            subscription.save(flush: true)
            render "Success"
        }else{
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

    def delete(Long id) {
        User user = User.get(id)
        if (user) {
            user.delete()
            render "Successful Deletion"
        } else {
            render "User not Found  "
        }
    }
}
