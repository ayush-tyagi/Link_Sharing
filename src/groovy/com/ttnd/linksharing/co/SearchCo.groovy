package com.ttnd.linksharing.co

import grails.validation.Validateable

/**
 * Created by ayush on 24/2/16.
 */
@Validateable
class SearchCo {
    String q
    String order
    String sort
    Integer max
    Integer offset
}
