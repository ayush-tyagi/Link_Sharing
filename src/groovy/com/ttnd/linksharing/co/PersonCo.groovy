package com.ttnd.linksharing.co

/**
 * Created by ayush on 2/3/16.
 */
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
