package com.ttnd.linksharing

class User {

    String email_id;
    String firstName;
    String lastName;
    String userName;
    String password;
    Boolean isActive;
    Boolean isAdmin;
    String confirmPassword;
    byte[] photo;
    Date lastUpdated;
    Date dateCreated;
    static transients = ['confirmPassword']
    static hasMany = [topics: Topic, subscriptions: Subscription, resources: Resource, ratingItems: ResourceRating, readingItems: ReadingItem]
    static mapping = {
        sort(id:'desc')
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
        confirmPassword(nullable: true,bindable:true, blank: true, validator: { confirmPassword, obj ->
            Long id = 0
            id = obj.getId()
            //println "---------------------------->>>>  ${id} ${obj.password} ${obj.confirmPassword}"
            if (!obj.id && obj.password != confirmPassword) {
                "password.mismatch.confirmPassword"
            }
        })
    }

    String toString() {
        return "${userName}"
    }

    String getName() {
        [this.firstName, this.lastName].join(' ')
    }
}
