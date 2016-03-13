package com.ttnd.linksharing.co

import com.ttnd.linksharing.User
import enums.L_Visibility

/**
 * Created by ayush on 13/3/16.
 */
class TopicSearchCo {
    Long id
    L_Visibility visibility

    public User getUser(){
        User user = User.get(id)
        return user
    }
}
