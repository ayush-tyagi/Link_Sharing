package com.ttnd.linksharing

     abstract class Resource {
    String description;
    User createdBy;
    Topic topic;
    Date lastUpdated;
    Date dateCreated;
    static hasMany = [readingItems:ReadingItem,resourceRatings:ResourceRating]
    static belongsTo = [topic:Topic]

    static mapping = {
        description(type:'text')
    }

    static constraints = {
    }
}

