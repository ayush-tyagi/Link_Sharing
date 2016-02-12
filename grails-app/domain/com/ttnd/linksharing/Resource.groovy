package com.ttnd.linksharing

abstract class Resource {
    String description;
    User createdBy;
    Topic topic;
    Date lastUpdated;
    Date dateCreated;
    static hasMany = [readingItem:ReadingItem,resourceRating:ResourceRating]
    static belongsTo = [topic:Topic]

    static mapping = {
        description(type:'text')
    }

    static constraints = {
    }
}
