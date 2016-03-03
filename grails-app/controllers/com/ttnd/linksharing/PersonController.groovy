package com.ttnd.linksharing

import com.ttnd.linksharing.co.PersonCo

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class PersonController {

    def myAction(String name, int age) {
        render name
        render age
        Person person = new Person(name: "Ayush", age: 24)
    }
    def myAction2(){
        Person person = new Person(name: "Ayush", age: 24)
        render person.properties
        render "<br>"
        person.properties = params
        render person.properties
    }
    def myList() {
        float num = params.float("quan")

        List list = params.list("a")
        render params.getProperties()
    }
    def dataBindWithErrors(){
        def b = new Person(params)
        render b.hasErrors()
        if(b.hasErrors()){
            render "The Value ${b.errors.getFieldError("age")}"
            if(b.errors.hasFieldErrors("age")){
                render b.errors.getFieldError("age").rejectedValue
            }
        }
    }

    def usingCo(PersonCo personCo){
        render personCo
    }
}
