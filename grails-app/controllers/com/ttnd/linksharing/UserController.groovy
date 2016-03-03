package com.ttnd.linksharing

import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo

class UserController {

    def index() {
        User user = session.user
//        User user = User.get(id)
        //render "User DashBoard ${session} ${user} ${user.userName}"
       List topicNames = Topic.getTopicsOfUser(user)
        List<TopicVo> trendingTopics = Topic.getTrendingTopics()

        List subscribedTopics = User.getSubscribedTopics(user)
        println "size : ${subscribedTopics.size()}"
        render(view:'index',model:[topicNames:topicNames,trendingTopics:trendingTopics,subscribedTopics:subscribedTopics])
    }

    def register() {
        User user = new User(email_id: "tyagi@hand.cm", userName: "safgagf", firstName: "afgffg", lastName: "gfggg", password: "fdfggggdfgr",confirmPassword: "fdfggggdfgr")
        if(user.validate() ){
            user.save()
            flash.message="Successful registration"
            render flash.message
        } else if (user.hasErrors()) {
            flash.message = "${user} not added--- ${user.errors.allErrors}"
            render "${user.errors.allErrors.collect { message(error: it) }.join(',')}"
            }
        }


    }
