package com.ttnd.linksharing

import com.ttnd.linksharing.co.TopicSearchCo
import com.ttnd.linksharing.co.UserCo
import com.ttnd.linksharing.co.UserSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
import dto.EmailDto
import enums.L_Visibility
import grails.converters.JSON
import org.apache.commons.lang.RandomStringUtils
import org.springframework.web.context.request.RequestContextHolder

class UserController {
    def assetResourceLocator
    def topicService
    def subscriptionService
    def mailService
    def emailService
    def grailsApplication
    def groovyPageRenderer


    def index() {
        User user = session.user
        List<Topic> topicNames = Topic.getTopicsOfUser(user)
        int numberOfSubscription = Subscription.countByUser(user)
        List<Topic> subscribedTopics = User.getSubscribedTopics(user)
        List<ReadingItem> readingItems = ReadingItem.findAllByUser(user, [sort: "dateCreated", order: "desc"])
        render(view: 'dashboard',
                model: [numberOfSubscription: numberOfSubscription, user: user,
                        readingItems        : readingItems, topicNames: topicNames, subscribedTopics: subscribedTopics])
    }

    def publicProfile(Long id) {
        Topic topic = Topic.get(id)
        User user = topic.createdBy
        int numberOfSubscription = Subscription.countByUser(user)
        TopicSearchCo topicSearchCo = new TopicSearchCo(id: user.id)
        List<TopicVo> subscribedTopics = subscriptionService.search(topicSearchCo)
        List<Topic> createdTopics = topicService.search(topicSearchCo)
        render(view: '/readingItem/profileGSP',
                model: [user         : user, numberOfSubscription: numberOfSubscription,
                        createdTopics: createdTopics, subscribedTopics: subscribedTopics])
    }

    def update(UserCo userCo) {
        User user = session.user
        session.user = null
        User user1 = user.get(user.id)
        if (user1) {
            user1.firstName = userCo.firstName
            user1.lastName = userCo.lastName
            user1.userName = userCo.userName
            if (userCo.photo) {
                user1.photo = userCo.photo.bytes
            }
            if (user1.validate()) {
                user1.save(flush: true)
                session.user = user1
                flash.message = "Successful updation"
                redirect(controller: 'user',action: 'profile')
            } else {
                flash.error = "Unsuccessful try"
            }
        } else {
            flash.error = "User not found"
        }
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

    def topics(Long id) {
//        println "---------------->>>>>>>>>>>>>${id}"
        TopicSearchCo topicSearchCo = new TopicSearchCo(id: id)

        if (session.user) {
            if (!(session.user.isAdmin || session.user.equals(User.load(id)))) {
                topicSearchCo.visibility = L_Visibility.PUBLIC
            }
        } else
            topicSearchCo.visibility = L_Visibility.PUBLIC

        List<TopicVo> createdTopics = topicService.search(topicSearchCo)

        render(template: '/readingItem/profileSubscription', model: [topics: createdTopics])
    }


    def subscriptions(Long id) {
//        println "---------------->>>>>>>>>>>>>${id}"
        TopicSearchCo topicSearchCo = new TopicSearchCo(id: id)

        if (session.user) {
            if (!(session.user.isAdmin || session.user.equals(User.load(id)))) {
                topicSearchCo.visibility = L_Visibility.PUBLIC
            }
        } else
            topicSearchCo.visibility = L_Visibility.PUBLIC

        List<TopicVo> subscribedTopics = subscriptionService.search(topicSearchCo)

        render(template: '/readingItem/profileSubscription', model: [topics: subscribedTopics])

    }

    def admin(UserSearchCo userSearchCo) {
        User user = session.user
//        println "----------params >> ${params}------>>>>>>>>>>${userSearchCo.properties}"
        if (user.isAdmin) {
            if (userSearchCo.q) {
                List<User> users = User.search(userSearchCo).list()
//                println "++++++++++++++++++++++++++++++++>>>>>>>>>${users}"
                render(view: '/user/UserListForAdmin', model: [users: users, co: userSearchCo])
            } else {
                List<User> users = User.createCriteria().list() {
                    ne('id', user.id)
                    if (null != userSearchCo.isActive) {
//                    println "----->> ${userSearchCo.isActive}"
                        eq('isActive', userSearchCo.isActive)
                    }
                }
//            println "------>> ${users} -- > ${userSearchCo.isActive}"
                render(view: '/user/UserListForAdmin', model: [users: users, co: userSearchCo])
            }
        } else {
            redirect(action: 'index')
        }
    }

    def changeToDeactive(long id) {
        User user = User.get(id)
        if (user.isActive) {
            if (User.executeUpdate("update User as u set u.isActive=${false} where u.id=${user.id}")) {

                List<User> users = User.createCriteria().list() {
                    ne('id', user.id)
                }
                render(template: '/user/ajaxListUser', model: [users: users])
            }
        } else {
            render([message: "${user.userName} is not active"] as JSON)
        }
    }

    def changeToActive(long id) {
        User user = User.get(id)
        if (!user.isActive) {
            if (User.executeUpdate("update User as u set u.isActive=${true} where u.id=${user.id}")) {
                render([message: "${user.userName} is activated Successfully"] as JSON)
            }
        } else {
            render([message: "${user.userName} is Active"] as JSON)
        }
    }

    def forgotPassword(String email) {
        User user = User.findByEmail_id(email)
//        println "=====>>><><>>>>${user}"
        if (user && user.isActive) {
            String randomPassword = RandomStringUtils.random(6, true, true)
//            println "==========<><><><><><><>${randomPassword}"
//            def session = RequestContextHolder.currentRequestAttributes().getSession()
            EmailDto emailDTO = new EmailDto(
                    to: [email],
                    subject: "New Password",
                    content: groovyPageRenderer.render(
                            template: '/login/randomPassword',
                            model: [userName : user.userName,
                                    randomPassword:randomPassword,
                                    base     : grailsApplication.config.grails.serverBaseURL])
            )
            if (emailService.sendMail(emailDTO)) {
                user.password = randomPassword
                if(user.save(flush: true)){
                    render("Success")
                }
            }else{
                render("Oops sorry")
            }

        }
    }

    /* def forgotPassword(String email, String userName) {
         User user = User.findByUserName(userName)
         String password = user.password
         if (user) {
             mailService.sendMail {
                 to "${email}"
                 from "ayush.tyagi@tothenew.com"
                 subject "Invitation request"
                 body "${userName} your password is  \"${password}\""
             }
             render("MAil sent to your email")
         } else {
             render("User does not exists")
         }
     }
 */
}
