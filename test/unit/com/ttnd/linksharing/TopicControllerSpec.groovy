package com.ttnd.linksharing

import enums.L_Visibility
import enums.Seriousness
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Topic,User])
@TestFor(TopicController)
class TopicControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test save method"() {
     setup:""
        Topic topic = new Topic(name:'Nitrous',visibility: L_Visibility.PUBLIC)
        
     when:""
        controller.save(topic,"SERIOUS")
        then:""
        response.text == "Success"
    }

     def "show method test"(){
        setup:""
        User user = new User(username: "bHelo",isActive:true , password: Constants.DEFAULT_PASSWORD, confirmPassword: "abcdef", firstName: "Name", lastName: "Krishna", email_id: "tyaysu@am.com")

        Topic topic = new Topic(name:'Krishna',visibility: L_Visibility.PUBLIC,id:1,createdBy: user)
         topic.save(flush:true)
         when:""
         controller.show(topic.id)
         then:""
         response.text=="Success"
     }


}
