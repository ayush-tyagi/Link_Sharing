package com.ttnd.linksharing

import com.ttnd.linksharing.co.TopicSearchCo
import com.ttnd.linksharing.co.UpdateCo
import com.ttnd.linksharing.co.UserCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
import enums.L_Visibility
import grails.converters.JSON

class UserController {
    def assetResourceLocator
    def topicService
    def subscriptionService
    def mailService


    def index() {
        User user = session.user
//        User user = User.get(id)
        //render "User DashBoard ${session} ${user} ${user.userName}"
        List<Topic> topicNames = Topic.getTopicsOfUser(user)
//        List<TopicVo> trendingTopics = Topic.getTrendingTopics()
        int numberOfSubscription = Subscription.countByUser(user)
//        println "----------------->>>>${numberOfSubscription}"
        List<Topic> subscribedTopics = User.getSubscribedTopics(user)
        List<ReadingItem> readingItems = ReadingItem.findAllByUser(user, [sort: "dateCreated", order: "desc"])
        render(view: 'dashboard', model: [numberOfSubscription: numberOfSubscription, user: user, readingItems: readingItems, topicNames: topicNames, subscribedTopics: subscribedTopics])
    }

    def register(UserCo userCo) {
        User user = User.findByUserNameOrEmail_id(userCo.userName, userCo.email_id)
        if (!user) {
            user = userCo.properties
            if (!params.photo.empty) {
                user.photo = params.photo.bytes
            }
            user.isActive = true
//            user.isAdmin=true
            if (user.validate()) {
                user.save(flush: true)
                flash.message = "Success"
                forward(controller: 'login', action: 'loginHandler', params: [userName: user.userName, password: user.password])
            } else {
                flash.error = "Not saved"
            }
        } else {
            flash.error = "User Already exists"
        }
        if (user.hasErrors()) {
            flash.user = user
            log.info(user.errors.allErrors)
        }
        redirect(controller: 'login', action: 'index', model: [userCo: userCo])
    }

    def image(Long id) {
        User user = User.get(id)
        if (user?.photo) {
            Byte[] img = user.photo
            response.outputStream.write(img)
        } else {
            response.outputStream << assetResourceLocator.findAssetForURI('girl1.png').getInputStream()
        }
        response.outputStream.flush()
    }

    def profile() {
        User user = session.user
        int numberOfSubscription = Subscription.countByUser(user)
        List<Topic> subscribedTopics = User.getSubscribedTopics(user)
        render(view: 'profile', model: [numberOfSubscription: numberOfSubscription, user: user, subscribedTopics: subscribedTopics])
    }

/*
    def topics(Long id) {

        TopicSearchCo topicSearchCo = new TopicSearchCo(id: id)

        if (session.user) {
            if (!(session.user.isAdmin || session.user.equals(User.load(id)))) {
                topicSearchCo.visibility = L_Visibility.PUBLIC
            }
        } else
            topicSearchCo.visibility = L_Visibility.PUBLIC

        List<TopicVo> createdTopics = topicService.search(topicSearchCo)

        render(view: '/topic/list', model: [topics: createdTopics])
    }


    def subscriptions(Long id) {

        TopicSearchCo topicSearchCo = new TopicSearchCo(id: id)

        if (session.user) {
            if (!(session.user.isAdmin || session.user.equals(User.load(id)))) {
                topicSearchCo.visibility = L_Visibility.PUBLIC
            }
        } else
            topicSearchCo.visibility = L_Visibility.PUBLIC

        List<TopicVo> subscribedTopics = subscriptionService.search(topicSearchCo)

        render(template: '/topic/list', model: [topics: subscribedTopics])

    }*/

    def admin() {
        if (session.user.isAdmin) {
            List<User> users = User.list([max: 20, sort: 'id', order: 'asc', offset: 0])
            render(view: '/user/UserListForAdmin', model: [users: users])
        }else{
            redirect(action: 'index')
        }
    }

    def changeToDeactive(long id){
        User user =User.get(id)
        if(user.isActive){
            if(User.executeUpdate("update User as u set u.isActive=${false} where u.id=${user.id}")){
                render([message:"${user.userName} is Deactivated Successfully"]as JSON)
            }
        }else{
            render([message:"${user.userName} is not active"]as JSON)
        }
    }

    def changeToActive(long id){
        User user =User.get(id)
        if(!user.isActive){
            if(User.executeUpdate("update User as u set u.isActive=${true} where u.id=${user.id}")){
                render([message:"${user.userName} is activated Successfully"]as JSON)
            }
        }else{
            render([message:"${user.userName} is Active"]as JSON)
        }
    }

    def forgotPassword(String email,String userName){
        User user = User.findByUserName(userName)
        String password=user.password
        if(user){
        mailService.sendMail {
            to "${email}"
            from "ayush.tyagi@tothenew.com"
            subject "Invitation request"
            body "${userName} your password is  \"${password}\""
        }
            render("MAil sent to your email")
        }else {
            render("User does not exists")
        }
    }

    def update(UpdateCo updateCo){
     User user = session.user
        if(user){
        if(User.executeUpdate("update User as u set u.firstName=${updateCo.firstName} and u.lastName=${updateCo.lastName}" +
                "and u.userName=${updateCo.userName} where u.id=${user.id}")){
            render "Successful updation"
        }    else{
            render "OOps"
        }
        }else{
            render "User not found"
        }
    }
}
