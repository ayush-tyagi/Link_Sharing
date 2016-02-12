package com.ttnd.linksharing

import enums.Seriousness
import grails.plugin.cache.SerializableOutputStream

class Subscription {
    Topic topic;
    User user;
    Date dateCreated;
    Date lastUpdated;
    Seriousness seriousness;
    static belongsTo = [user:User,topic:Topic]
    static constraints = {

        user(unique:'topic');
    }
}
