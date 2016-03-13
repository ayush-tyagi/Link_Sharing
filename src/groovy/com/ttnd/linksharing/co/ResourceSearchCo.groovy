package com.ttnd.linksharing.co

import enums.L_Visibility
import grails.validation.Validateable

/**
 * Created by ayush on 24/2/16.
 */
@Validateable
class ResourceSearchCo extends SearchCo{
    Long topicId
    L_Visibility visibility = L_Visibility.PUBLIC
}
