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
    static transients = ['subscribedUsers']
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

    static List<TopicVo> getTrendingTopics(){

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
        List<TopicVo> topicVos = []
        results.each { result ->
            topicVos.add(new TopicVo(id: result[0] as Long, name: result[2], visibility: L_Visibility.PUBLIC, createdBy: result[3] as User, count: result[1] as Integer))
        }
       topicVos

    }

    static List<Topic> getTopicsOfUser(User user){
     List<Topic> topicList =Topic.findAllByCreatedBy(user)
//     List topicNames = topicList.collect{it.name}
     return topicList
    }

    List getRecenrShares(){
        List list=Subscription.createCriteria().list(){
            createAlias('topic','t')

            projections{
                distinct('t.name')

            }
        }
    list
    }

    List<User> getSubscribedUsers(){
        List list=Subscription.createCriteria().list(){
            eq('topic',this)
            projections{
                createAlias('user','u')
                property('u.userName')
            }
        }
        list
    }

    Boolean isPublic(Long id){
        Topic topic = Topic.get(id)
        if(topic.visibility == L_Visibility.PUBLIC){
            true
        }else{
            false
        }
    }

    Boolean canViewedBy(Long id){
        Topic topic = Topic.get(id)
        List<User> user = topic.subscribedUsers
        if(topic.isPublic(id) || user?.isAdmin || this.contains(user) ){
          true
        }else{
            false
        }
    }
}
