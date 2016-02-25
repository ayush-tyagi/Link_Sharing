package com.ttnd.linksharing

import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
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
    { return "Topic ${id}"
    }
    def afterInsert() {
        Topic.withNewSession {
            Subscription subscription = new Subscription(topic: this, user: this, seriousness: Seriousness.VERY_SERIOUS)
            if (subscription.validate()) {
                subscription.save()
            }
        }
    }

    static List getTrendingTopics(){

        List results = Topic.createCriteria().list([max:5]){
            eq('visibility',L_Visibility.PUBLIC)
            'projections'{
                createAlias('resources','r')
                groupProperty('id')
                count('r.id','cnt')
                property('name')
                property('createdBy')
            }
            order('cnt','desc')
            order('name','desc')

        }
        results
    }

    static List getTopicsOfUser(User user){
     List<Topic> topicList =Topic.findAllByCreatedBy(user)
     List topicNames = topicList.collect{it.name}
     return topicNames
    }
}
