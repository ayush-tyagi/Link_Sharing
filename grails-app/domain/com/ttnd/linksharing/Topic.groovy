package com.ttnd.linksharing

import enums.L_Visibility
import enums.Seriousness

class Topic {
    String name;
    User createdBy;
    L_Visibility visibility;
    Date lastUpdated;
    Date dateCreated;
    static hasMany = [subscriptions: Subscription,resources:Resource]
    static constraints = {
        name(blank: false, unique: 'createdBy');
        visibility(inlist: L_Visibility.values() as List);
    }
    static mapping = {
        sort(name:'asc')
    }
    String toString()
    { return "Topic :${name}"
    }
    def afterInsert() {
        withNewSession {
            Subscription subscription = new Subscription(topic: this, user: this, seriousness: Seriousness.VERY_SERIOUS)
            if (subscription.validate()) {
                subscription.save()
            }
        }
    }
}
