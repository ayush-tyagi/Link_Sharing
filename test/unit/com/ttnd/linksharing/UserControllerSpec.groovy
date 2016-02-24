package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
class UserControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
    def" Resgister test"() {
        when:""
        controller.register()
        then:""
        response.text=="Successful registration"
    }

    def"Testing Index action"(){
        setup:""
        User user = new User(email_id: "tyagisyusb@hjgd.vb", firstName: "Jai", lastName: "Ho", password: "Hellopoiyt", userName: "Aakash")
        when:""
        controller.index(user.id)
        then:""
        response.text =="User DashBoard Session Content: User is : Krishna Krishna"
    }
}
