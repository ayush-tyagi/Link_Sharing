package com.ttnd.linksharing

import enums.Seriousness

class SubscriptionController {

    def index() { }

    def save(long id){
        def topic = Topic.get(id)
        def user = session["user"]
        def subscription = new Subscription(topic:topic,user:user)
        if(subscription.validate()){
            subscription.save()
            render "Success"
        }else{
            render "Error"
        }
    }

    def update(long id){                           //,Seriousness seriousness
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
    }

    def delete(long id){
        def user = User.get(id)
        if(user){
         user.delete()
            render "Successful Deletion"
        }
        else{
            render "User not Found  "
        }
    }
}
