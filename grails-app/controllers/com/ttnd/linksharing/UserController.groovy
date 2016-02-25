package com.ttnd.linksharing

class UserController {

    def index() {
//        User user = User.get(id)
        //render "User DashBoard ${session} ${user} ${user.userName}"
       List topicNames= Topic.getTopicsOfUser(session.user)
        render(view:'index',model:[topicNames:topicNames])
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
