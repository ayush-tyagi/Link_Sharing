package com.ttnd.linksharing

class UserController {

    def index(long id) {
        User user = User.get(id)
        render "User DashBoard ${session} ${user} ${user.userName}"
    }

    def register() {
        User user = new User(email_id: params.email, userName: params.userName, firstName: params.firstName, lastName: params.lastName, password: params.password)
        if(user.validate() && user.save()){
            flash.message="Successful registration"
            render flash.message
        } else if (user.hasErrors()) {
            errors.allErrors.each {
                render "${it}"
            }
        }


    }
}