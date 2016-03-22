package com.ttnd.linksharing

class LoginController {
    def mailService


    def index() {
        User user = session.user
        if (user) {
            log.info user.userName
            redirect(action: "index", controller: "user")
        } else {
            List recentShares = Topic.list([sort: 'dateCreated', order: 'desc', max: 2, offset: 0])
            render view: 'index', model: [recentShares: recentShares, user: flash.user, params: params]
        }
    }

    def loginHandler(String userName, String password) {
        User user = User.findByUserNameAndPassword(userName, password)
        if (user) {
            if (user.isActive) {
                session.user = user
            } else {
                flash.error = "Your account is not active.."
            }
        } else {
            flash.error = "User not Found.."
        }
        redirect(action: "index")
//
//        List<Resource> resources1 = Resource.getTopPosts()
//        render view:'index',model: [resources1:resources1]
    }

    def logout() {
        session.invalidate()
        forward(action: "index")
    }

//    def showTopics() {
//    }
    def forgotPassword() {
        render(view: '/login/forgotPassword')
    }

    def testMail(String email, String topicName) {
        Topic topic = Topic.findByName(topicName)
        println "----------------${topic}"
        if (topic) {
            mailService.sendMail {
                to "${email}"
                from "ayush.tyagi@tothenew.com"
                subject "Invitation request"
                body "You have recieved Invitation for Topic \"${topic.name}\"  from \"ayush.tyagi@tothenew.com\""
            } render("You have successfully sent an invitation to ${email}")
        } else {
            render("Topic does not exists")
        }
    }


    def changePassword(String password, String confirmPassword) {
        User user = session.user
        if (password!="" && password == confirmPassword) {
            user.password = password
            if (User.executeUpdate("update User as u set u.password=:password where u.id=${user.id}", [password: password])) {
                flash.message="Your password is changed successfully "
            } else {
                flash.error = "Sorry your password  cannot be updated"
            }
        } else {
            flash.error = "Password does not match with confirm password or left blank"
        }
        redirect(controller: 'user',action: 'profile')
    }
    /*def triggerMail() {
        if( UnreadItemEmailJob.triggerNow()){
    render "Success"
        }else{
            render "Failure"
        }
    }*/
}
