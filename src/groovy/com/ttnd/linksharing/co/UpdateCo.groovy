package com.ttnd.linksharing.co

import grails.validation.Validateable

/**
 * Created by ayush on 13/3/16.
 */
@Validateable
class UpdateCo {

    String firstName
    String lastName
    String userName
    def photo

    static constraints ={

        firstName(blank: false)
        lastName(blank: false)
        userName (blank:false , unique:true)
        photo(nullable:true,blank:true)
    }
}
