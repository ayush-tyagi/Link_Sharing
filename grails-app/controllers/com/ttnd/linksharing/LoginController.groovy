package com.ttnd.linksharing

class LoginController {
    def mailService

    def index() {
        User user = session.user
        if (user) {
            log.info user.userName
            forward(action: "index", controller: "user", id: user.id)
        } else {
            List recentShares = Topic.list([sort: 'dateCreated', order: 'desc', max: 2, offset: 0])
//            List<Resource> resources1 = Resource.getTopPosts()
            render view: 'index', model: [recentShares: recentShares,user:flash.user, params : params]
            //  render "Failure Login"
        }
    }

    def loginHandler(String userName, String password) {
        User user = User.findByFirstNameAndPassword(userName, password)
        if (user) {
            if (user.isActive) {
                session.user = user
                redirect(action: "index")
            } else {
                println "---------Hello else active"
                flash.message = "Your account is not active.."
                render flash.message
            }
        } else {
            println "---------Hello else out active"
            flash.message = "User not Found.."
            render flash.message
        }
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


    def testMail() {
        mailService.sendMail {
            to "ayush.tyagi@tothenew.com"
            from "ayush.tyagi@tothenew.com"
            subject "Hello Tyagi"
            body 'Or btao kyaa haal hain'
        }

    }


}
