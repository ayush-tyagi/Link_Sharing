package com.ttnd.linksharing

import com.ttnd.linksharing.co.UserCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo

class UserController {

    def index() {
        User user = session.user
//        User user = User.get(id)
        //render "User DashBoard ${session} ${user} ${user.userName}"
        List<Topic> topicNames = Topic.getTopicsOfUser(user)
//        List<TopicVo> trendingTopics = Topic.getTrendingTopics()

        List<Topic> subscribedTopics = User.getSubscribedTopics(user)
        List<ReadingItem> readingItems = ReadingItem.findAllByUser(user, [sort: "isRead", order: "asc"])
        render(view: 'index', model: [readingItems: readingItems, topicNames: topicNames, subscribedTopics: subscribedTopics])
    }

    def register(UserCo userCo) {
        User user = new User(email_id: userCo.email_Id, userName:userCo.userName , firstName: userCo.firstName, lastName: userCo.lastName, password: userCo.password, confirmPassword: userCo.confirmPassword)
        if (user.validate()) {
            user.save()
            flash.message = "Successful registration"
            render flash.message
        } else if (user.hasErrors()) {
            flash.message = "${user} not added--- ${user.errors.allErrors}"
            render "${user.errors.allErrors.collect { message(error: it) }.join(',')}"
        }
    }


}
