package com.ttnd.linksharing.co

import com.ttnd.linksharing.User
import enums.L_Visibility
import grails.validation.Validateable

/**
 * Created by ayush on 13/3/16.
 */
@Validateable
class TopicSearchCo extends SearchCo {
    Long id
    L_Visibility visibility

    public User getUser(){
        User user = User.get(this.id)
        println "=============>>>>>>${user}"
        return user
    }
}
