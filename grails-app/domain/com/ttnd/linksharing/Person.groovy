package com.ttnd.linksharing

class Person {

    String name
    Integer age
    String address

    static constraints = {
        address(nullable: true)
    }
}
