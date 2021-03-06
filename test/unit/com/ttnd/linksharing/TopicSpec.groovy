package com.ttnd.linksharing

import enums.L_Visibility
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

import java.beans.Visibility

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Topic)
class TopicSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    @Unroll
    def "test something"() {
        given: ""
        String topicName = "Grails";


        User user = new User(email_id: "helloa@yt.com", firstName: "Jai", lastName: "Ho", password: "Hellopoiyt", userName: "Ram");
        Topic topic = new Topic(name: topicName, createdBy: user, visibility: L_Visibility.PUBLIC);
        when: "User will save"
        topic.save();

        then: ""
        topic.count() == 1;

        when: ""
        Topic newTopic = new Topic(name: topicName, createdBy: user, visibility: L_Visibility.PUBLIC);
        newTopic.save();

        then:
        topic.count() == 1;
        newTopic.errors.allErrors.size() == 1;
        newTopic.errors.getFieldErrorCount('name') == 1;


    }

    @Unroll
    def "Visibility should not be null & must be enum"() {
        setup: "user created topic"
        Topic topic = new Topic(name: name, visibility: L_Visibility.PUBLIC)

        when: "check for valiation"
        Boolean result = topic.validate()

        then: "test the result"
        result == valid

        where: "trying different values"

        sno | name     | visibility | valid
        1   | "grails" | " "        | false
        2   | "java"   | null       | false
        3   | "grails" | "PUBLIC"   | true
        4   | "grails" | "PRIVATE"  | true
        5   | "grails" | "xyz"      | false

    }
}
