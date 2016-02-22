package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LoginController)
class LoginControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test index action"() {
        setup:""
        User user = new User(userName: "bHelo", password: Constants.DEFAULT_PASSWORD, confirmPassword: "abcdef", firstName: "Name", lastName: "Krishna", email_id: "tyaysu@am.com")
        session['user'] = user
        when: ""
        controller.index()
        then: ""
        response.forwardedUrl=="/user/index"
    }
    def "test logout"() {
        when: ""
        controller.logout()

        then: ""
        response.forwardedUrl == "/login/index"
    }

    def "test loginHandler"(){
    setup:""

    }
}
