package com.ttnd.linksharing

import com.ttnd.linksharing.co.TopicSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
import grails.transaction.Transactional

@Transactional
class SubscriptionService {

    def serviceMethod() {

    }

    List<TopicVo> search(TopicSearchCo topicSearchCo){
        if(topicSearchCo.id)
        {
            User user = topicSearchCo.getUser()
            return user.getSubscribedTopics()
        }
    }

}
