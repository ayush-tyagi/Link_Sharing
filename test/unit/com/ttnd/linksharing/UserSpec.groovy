package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    @Unroll
    def "Check #email_id"() {
        given: "User Object"

        /*String email_id = "tyagiayus@tv.com";
        String firstName = "Krishna";
        String lastName = "Yadav";
        String userName = "Hello";
        String password = "igdefault";*/
        User user = new User(email_id: "helloa@yt.cm", password: "defger");

        when: "User will save"
        user.save();

        then: ""
        user.count() == 1;

        when: ""
        user = new User(email_id: email_id, firstName: "Jai", lastName: "Ho", password: "Hellopoiyt", username: "Ram");
        user.save();

        then:
        user.count() == 1;
        user.errors.allErrors.size() == 1;
        user.errors.getFieldErrorCount('email_id') == 1;

    }

    @Unroll
    def "checking all fields with #password"() {

        given: "Create object"
        User user = new User(password: password, username: userName, firstName: firstName, lastName: lastName, email_id: email_id)

        when:
        user.save()
        boolean result = user.validate()
        then:
        result == validate

        where:
        password | userName      | firstName | lastName | email_id     | validate
        "s"      | "Ayush tyagi" | "Ayush"   | "tyagi"  | "tyhg@s.com" | false
        "s"      | "Ayush tyagi" | "Ayush"   | "tyagi"  | "jkhs "      | false
        "swer"   | "Ayush tyagi" | "Ayush"   | "tyagi"  | "tyhg@s.com" | false
        "swerew" | "Ayush tyagi" | "Ayush"   | "tyagi"  | "tyhg@s.com" | true
    }

    def "Checking the toString method"() {
        given: "User"
        User user = new User(email_id: "tyagisyusb@hjgd.vb", firstName: "Jai", lastName: "Ho", password: "Hellopoiyt", username: userName)

        when: ""
        String result = user.toString()

        then:
        result == resultantString

        where:
        userName  | resultantString
        "Krishna" | "User is : Krishna"
        ""        | "User is : null"
        null      | "User is : null"


    }
}
