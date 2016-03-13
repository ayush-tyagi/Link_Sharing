package com.ttnd.linksharing

import com.ttnd.linksharing.co.TopicSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
import grails.transaction.Transactional

@Transactional
class TopicService {

    def serviceMethod() {

    }
    List<Topic> search(TopicSearchCo topicSearchCo) {
        List<TopicVo> createdTopicsList = []

        if (topicSearchCo.id) {
            User user = topicSearchCo.getUser()

            List<Topic> topicList = Topic.createCriteria().list(max: topicSearchCo.max) {
                eq('createdBy.id', topicSearchCo.id)

                if (topicSearchCo.visibility)
                    eq('visibility', topicSearchCo.visibility)
            }

            topicList.each {
                topic -> createdTopicsList.add(new TopicVo(id: topic.id,
                        name: topic.name, visibility: topic.visibility, createdBy: topic.createdBy))
            }

        }

        return createdTopicsList
    }
}
