package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.RatingInfoVo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
import enums.L_Visibility

class ResourceController {

    def index() {}

    def delete(Long id) {
        Resource resource = Resource.load(id)
        if (resource) {
            try {
                resource.delete(flush: true)
                render "Successful Deletion"
            }
            catch (Exception e) {
                render "Unsuccessful"
            }
        } else {
            render "Not Found"
        }
    }

    def search(ResourceSearchCo co) {
        if(co.q) {
            co.visibility = L_Visibility.PUBLIC
            List<Resource> resources = Resource.search(co).list()
            render resources
        }
    }

    def show(Long id) {
        println "____>>>>>>>>>>>${id}"
        Resource resource = Resource.get(id)
        if (resource) {
            RatingInfoVo ratingInfoVo = resource.getRatingInfoVo()
            render "${ratingInfoVo}"
        } else {
            flash.error = "Resource not found"
            redirect(uri: '/')
        }

        List list = Topic.getTrendingTopics()
        List<TopicVo> topicVos = []
        list.each { results ->
            topicVos.add(new TopicVo(id: results[0] as Long, name: results[2], visibility: L_Visibility.PUBLIC, createdBy: results[3] as User, count: results[1] as Integer))
        }
        render "${topicVos*.properties}"
    }

    def saveDocumentResource(String description, String topicName, String filePath) {
        User user= session.user
        Topic topic = User.getTopicByName(topicName)
        DocumentResource documentResource = new DocumentResource(description: description, topic: topic, filePath: filePath)
        if (documentResource.validate()) {
            documentResource.save(flush: true)
            render "Successful Save"
        } else {
            render "Unsuccessful"
        }
    }
}
