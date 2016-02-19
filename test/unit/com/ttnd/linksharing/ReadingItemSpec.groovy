package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ReadingItem)
class ReadingItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

   /*void "test something"() {
        setup: "user rated resource"
        User user = new User(firstName: "ayush", lastName: "tyagi", email: "a@b.com", password: "qwerty", username: "abc")
        LinkResource linkResource = new LinkResource(description: " this is helpfull", createdBy: user, topic: "grails", url: "http://grails.github.io/grails-doc/2.5.1/ref/Constraints/url.html")
        ReadingItem readingItem = new ReadingItem(resources: linkResource, user: user, isRead: true)

        when:
        readingItem.save(flush:true)



        then:
        //ReadingItem.count() == 1
        readingItem.errors.allErrors.size() == 1

        when:
        ReadingItem readingItemNew = new ReadingItem(resources: linkResource, user: user, isRead: true)
        readingItemNew.save(flush:true)

        then:
        //ReadingItem.count() == 1
        readingItemNew.errors.allErrors.size() == 1
        readingItemNew.errors.getFieldErrorCount('resource') == 1
    }*/

    void "test for ReadingItem"() {
        setup:

        User user = new User(firstName: "ayush", lastName: "tyagi", email: "a@b.com", password: "qwerty", username: "abc")
        LinkResource linkResource = new LinkResource(description: " this is helpfull", createdBy: user, topic: "grails", url: "http://grails.github.io/grails-doc/2.5.1/ref/Constraints/url.html")

        ReadingItem readingItem = new ReadingItem(resources: linkResource, user: user, isRead: isread)
        when:
        Boolean result = readingItem.validate()
        then:
        result == valid
        where:
        isread | valid
        true   | true
        false  | true
        null   | false


    }

}
