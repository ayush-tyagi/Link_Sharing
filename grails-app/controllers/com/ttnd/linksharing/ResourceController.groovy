package com.ttnd.linksharing

import com.ttnd.linksharing.co.LinkResourceCo
import com.ttnd.linksharing.co.ResourceSearchCo
import enums.L_Visibility

class ResourceController {

    def index() {}

    def delete(Long id) {
        Resource resource = Resource.load(id)
        User user = session.user
        if (user.canDeleteResource(id)) {
            try {
                resource.deleteFile()
                flash.message = "File deleted"
            }
            catch (Exception e) {
                flash.error = "File can\'t deleted"
            }
        } else {
            flash.error = "User is not priviliged to delete this resource"
        }
        redirect(controller: 'user', action: 'index')
    }

    def search(ResourceSearchCo co) {
        if (co.q) {
            co.visibility = L_Visibility.PUBLIC
            List<Resource> resources = Resource.search(co).list()
            render resources
        } else {
            flash.error = "Search Criteria not given"
        }
    }

    def show(Long id) {
        Resource resource = Resource.get(id)
        User user = session.user
        if (resource.canViewBy(user)) {
//            RatingInfoVo ratingInfoVo = resource.getRatingInfoVo()
//            render "${ratingInfoVo}"
            render(view: '/resource/resourceShow', model: [resource: resource])
        } else {
            flash.error = "Resource not found"
            redirect(uri: '/')
        }

//        List<TopicVo> list = Topic.getTrendingTopics()
//        render view: '/topic/trendingTopics'
        //render list*.properties
    }

    protected void pushReadingItems(Resource resource) {
        Topic topic = resource.topic
        println " "
        println "..............Topic..................>${topic}"
        List<User> users = topic.getSubscribedUsers()

        users.each { User user ->
            if (resource.createdBy != user) {
                println "...............Users.................>${users}"
                ReadingItem item = new ReadingItem(resource: resource, user: user, isRead: false).save(flush: true, failOnError: true)
                /*user.addToReadingItems(item)
                user.save(flush: true, failOnError: true)
                resource.addToReadingItems(item)*/
            }
        }
//        resource.save(flush: true, failOnError: true)
    }

// def saveDocumentResource(String description, String topicName, String filePath) {
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

    /*def save(LinkResourceCo linkResourceCo) {
        User user= session.user
        Topic topic = Topic.findByNameAndCreatedBy(linkResourceCo.topicName,user)
        Resource linkResource = new LinkResource(description: linkResourceCo.description,
                topic: topic,createdBy: user,url: linkResourceCo.link)
        if (linkResource.validate()) {
            linkResource.save(flush: true)
            render "Successful Save"
        } else {

            render linkResource.errors
        }
    }
*/
}
