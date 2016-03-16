package com.ttnd.linksharing.co

import grails.validation.Validateable

/**
 * Created by ayush on 2/3/16.
 */
@Validateable
class PersonCo {
    String name
    int age
    static constraints ={
        name(nullable:false)
        age(nullable:false)
    }
   String toString(){
       return "Name:  ${name}-----Age:   ${age}"
   }
}
