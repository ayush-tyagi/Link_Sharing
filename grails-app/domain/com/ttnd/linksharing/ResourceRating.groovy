package com.ttnd.linksharing

class ResourceRating {

    Resource resource
    Integer score
    User user
    Date lastUpdated
    Date dateCreated
    static belongsTo = [user:User,resource:Resource]
    static constraints = {
        score(min:1,max:5)
        user(unique:'resource')
    }
}
