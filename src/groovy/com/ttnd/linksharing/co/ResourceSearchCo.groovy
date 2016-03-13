package com.ttnd.linksharing.co

import com.ttnd.linksharing.User
import enums.L_Visibility
import grails.validation.Validateable

/**
 * Created by ayush on 24/2/16.
 */
@Validateable
class ResourceSearchCo extends SearchCo{
    Long id
    Long topicId
    L_Visibility visibility = L_Visibility.PUBLIC

    public User getUser(){
        User user = User.get(id)
        return user
    }
}

