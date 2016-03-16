package com.ttnd.linksharing.co

import grails.validation.Validateable

@Validateable
class UserSearchCo extends SearchCo {
    Boolean isActive = null
}
