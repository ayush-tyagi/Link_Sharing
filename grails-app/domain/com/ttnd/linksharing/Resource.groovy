package com.ttnd.linksharing

import CO.ResourceSearchCo

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

    static namedQueries = {
        search{ ResourceSearchCo co->
            if(co.topicId) {
             'topic' {
                 eq('id',co.topicId)

             }
            }
        }
    }

    String toString()
    {
    return "${topic.name}"
    }
}

