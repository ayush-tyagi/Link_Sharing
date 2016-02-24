package com.ttnd.linksharing

import enums.Seriousness
import grails.plugin.cache.SerializableOutputStream

class Subscription {
    Topic topic
    User user
    Date dateCreated
    Date lastUpdated
    Seriousness seriousness = Seriousness.SERIOUS
    static belongsTo = [user:User,topic:Topic]
    static constraints = {
        user unique:'topic'
    }

    static mapping = {

    }

}
