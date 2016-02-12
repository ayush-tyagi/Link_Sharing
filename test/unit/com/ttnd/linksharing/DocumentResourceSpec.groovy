package com.ttnd.linksharing

import enums.L_Visibility
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DocumentResource)
class DocumentResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test something"() {
        setup: "user added resourse document"
        User user = new User(firstName: "Ayush", lastName: "tyagi", email: "a@b.com", password: "qwerty", username: "abc")
        Topic topic = new Topic(name: "grails", visibility: L_Visibility.PRIVATE, createdBy: user)
        DocumentResource documentResource = new DocumentResource(filePath: filepath, description: "this is helpfull", topic: topic, createdBy: user)

        when: "check for validation"
        Boolean result = documentResource.validate()

        then: "test the result"
        result == valid

        where: "trying different values"

        sno | filepath     | valid
        1   | " "          | false
        2   | null         | false
        3   | "/home/sona" | true


    }
}
