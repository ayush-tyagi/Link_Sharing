package com.ttnd.linksharing

import grails.transaction.Transactional

@Transactional
class UtilService {

    def serviceMethod() {
    }

    def firstService(){
        User user1 = new User( password: "hello",userName:"M",
                confirmPassword: "hello", firstName: "Naman", lastName: "Radha", email_id: "tyddsu@am.com")
        user1.validate()
        user1.save()
    }
}
