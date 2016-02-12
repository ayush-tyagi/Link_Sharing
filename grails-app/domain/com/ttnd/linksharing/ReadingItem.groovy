package com.ttnd.linksharing

class ReadingItem {

    Resource resource;
    User user;
    boolean isRead;
    Date lastUpdated;
    Date dateCreated;
    static belongsTo = [user:User,resource:Resource]
    static constraints = {
    }
}
