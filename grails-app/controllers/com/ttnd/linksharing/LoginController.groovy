package com.ttnd.linksharing

class LoginController {
    def index() {
        User user = session["user"]
        if (user) {
            forward(action: "index", controller: "User", id: user.id)
        } else {
            render "Failure Login"
        }
    }

    def loginHandler(String name, String password) {
        User user = User.findByFirstNameAndPassword(name, password)
        if (user) {
            if (user.isActive) {
                session["user"] = user
                redirect(action: "index", controller: "login")
            } else {
                flash.message = "Your account is not active.."
                render flash.message
            }
        } else {
            flash.message = "User not Found.."
            render flash.message
        }


        List ids = []
        List results = Resource.topPost()
        results.each {
            ids.add(it[0])
        }
        List<Resource> resources = Resource.getAll(ids)

        render "${resources}"
    }

    def logout() {
        session.invalidate()
        forward(action: "index")
    }

//    def showTopics() {
//    }

}
