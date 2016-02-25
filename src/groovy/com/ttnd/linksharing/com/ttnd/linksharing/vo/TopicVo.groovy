package com.ttnd.linksharing.com.ttnd.linksharing.vo

import com.ttnd.linksharing.User
import enums.L_Visibility

/**
 * Created by ayush on 24/2/16.
 */
class TopicVo {
    Long id
    String name
    L_Visibility visibility
    Integer count
    User createdBy
}
