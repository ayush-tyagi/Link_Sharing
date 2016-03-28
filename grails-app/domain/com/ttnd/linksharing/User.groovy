package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCo
import com.ttnd.linksharing.co.UserSearchCo
import enums.Seriousness
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User  implements Serializable {

    private static final long serialVersionUID = 1

    transient springSecurityService

    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    String email_id;
    String firstName;
    String lastName;
    String username;
    String password;
    Boolean isActive;
    Boolean isAdmin;
    String confirmPassword
    List subscribedTopics
    byte[] photo;
    Date lastUpdated;
    Date dateCreated;
    static transients = ['confirmPassword', 'subscribedTopics','springSecurityService']
    static hasMany = [topics: Topic, subscriptions: Subscription, resources: Resource, ratingItems: ResourceRating, readingItems: ReadingItem]
    static mapping = {
        sort(id: 'desc')
        photo(sqlType: 'longblob')
        password column: '`password`'
    }


    static constraints = {
        email_id(unique: true, blank: false, email: true)
        password(blank: false, minSize: 5)
        firstName(blank: false)
        lastName(blank: false)
        isActive(nullable: true)
        isAdmin(nullable: true)
        photo(nullable: true)
        username (nullable: false,unique:true)
        confirmPassword(nullable: true, bindable: true, blank: true, validator: { confirmPassword, obj ->
            Long id = 0
            id = obj.getId()
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

    User(String username, String password) {
        this()
        this.username = username
        this.password = password
    }

    Set<SecAppRole> getAuthorities() {
        SecAppUserSecAppRole.findAllBySecAppUser(this)*.secAppRole
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }


    String toString() {
        return "${username}"
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
