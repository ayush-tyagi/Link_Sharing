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

        List<TopicVo> list = Topic.getTrendingTopics()
        render view: '/topic/trendingTopics'
        //render list*.properties
    }

    def saveLinkResource(String description, String topicName, String link) {
        println "==========>${params}"
        User user= session.user
        Topic topic = Topic.findByNameAndCreatedBy(topicName,user)
        println "---------------->${topic}"
        Resource linkResource = new LinkResource(description: description,topic: topic,createdBy: user,url: link)
        println "=============================>>>>>${linkResource}"
        if (linkResource.validate()) {
            linkResource.save(flush: true)
            render "Successful Save"
        } else {
            render "Unsuccessful"
        }
    }


//    def saveDocumentResource(String description, String topicName, String filePath) {
//        User user= session.user
//        Topic topic= Topic.findByNameAndCreatedBy(topicName,user)
//        DocumentResource documentResource = new DocumentResource(description: description, topic: topic, filePath: filePath)
//        if (documentResource.validate()) {
//            documentResource.save(flush: true)
//            render "Successful Save"
//        } else {
//            render "Unsuccessful"
//        }
//    }
}
