package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCo
import com.ttnd.linksharing.co.UserSearchCo
import enums.Seriousness

class User {

    String email_id;
    String firstName;
    String lastName;
    String userName;
    String password;
    Boolean isActive;
    Boolean isAdmin;
    String confirmPassword
    List subscribedTopics
    byte[] photo;
    Date lastUpdated;
    Date dateCreated;
    static transients = ['confirmPassword', 'subscribedTopics']
    static hasMany = [topics: Topic, subscriptions: Subscription, resources: Resource, ratingItems: ResourceRating, readingItems: ReadingItem]
    static mapping = {
        sort(id: 'desc')
        photo(sqlType: 'longblob')

    }


    static constraints = {
        email_id(unique: true, blank: false, email: true)
        password(blank: false, minSize: 5)
        firstName(blank: false)
        lastName(blank: false)
        isActive(nullable: true)
        isAdmin(nullable: true)
        photo(nullable: true)
        userName nullable: false
        confirmPassword(nullable: true, bindable: true, blank: true, validator: { confirmPassword, obj ->
            Long id = 0
            id = obj.getId()
            //println "---------------------------->>>>  ${id} ${obj.password} ${obj.confirmPassword}"
            if (!obj.id && obj.password != confirmPassword) {
                "password.mismatch.confirmPassword"
            }
        })
    }

    static namedQueries = {
        search { UserSearchCo co ->
            or {
                ilike('userName',"%${co.q}%")
                ilike('firstName',"%${co.q}%")
                ilike('lastName',"%${co.q}%")
                ilike('email_id',"%${co.q}%")
            }

        }
    }


    String toString() {
        return "${userName}"
    }
/*
    String getUserName() {
        [this.firstName, this.lastName].join(' ')
    }*/

    static List<Topic> getSubscribedTopics(User user) {
        List<Topic> list = Subscription.createCriteria().list([sort:'lastUpdated',order:'desc']) {
            projections {
                distinct('topic')
            }
            eq('user', user)
        }
        list
    }

    Boolean canDeleteResource(Long id) {
        Resource resource = Resource.get(id)
        if (resource.createdBy == this || this?.isAdmin) {
            true
        } else {
            false
        }
    }

    int getScore(Long id) {
        Resource resource = Resource.get(id)
        ResourceRating resourceRating = ResourceRating.findByResourceAndUser(resource, this)
        int score = resourceRating.score
        return score
    }

    Boolean isSubscribe(Long topicId) {
        Subscription subscription = Subscription.findByTopicAndUser(Topic.get(topicId), this)
        if (subscription) {
            return true
        }
        return false
    }

    Seriousness getSubscriptionSeriousness(Long id) {
        Topic topic = Topic.get(id)
        Subscription subscription = Subscription.findByTopicAndUser(topic, this)
        return subscription.seriousness
    }

    Boolean equalSessionUser(Long id) {
        Topic topic = Topic.get(id)
        if (this == topic.createdBy) {
            return true
        } else {
            return false
        }
    }

}
