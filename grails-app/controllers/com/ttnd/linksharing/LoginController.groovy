package com.ttnd.linksharing

class LoginController {
    def index() {
        User user = session.user
        if (user) {
            log.info user.userName
            forward(action: "index", controller: "user", id: user.id)
        } else {
            List recentShares = Topic.list([sort: 'dateCreated',order: 'desc',max: 2,offset: 0])
            List<Resource> resources1 = Resource.getTopPosts()
            render view:'index',model: [resources1:resources1,recentShares:recentShares]
          //  render "Failure Login"
        }
    }

    def loginHandler(String userName, String password) {
        User user = User.findByFirstNameAndPassword(userName, password)
        if (user) {
            if (user.isActive) {
                session.user=user
                redirect(action: "index", controller: "login")
            } else {
                flash.message = "Your account is not active.."
                render flash.message
            }
        } else {
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

}
