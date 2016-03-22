package com.ttnd.linksharing

import com.ttnd.linksharing.co.LinkResourceCo
import grails.converters.JSON

class LinkResourceController extends ResourceController{

    def index() {
        render "Hello index"
    }

    def save(LinkResourceCo linkResourceCo) {
        User user= session.user
        Topic topic = Topic.findByNameAndCreatedBy(linkResourceCo.topicName,user)
        Resource linkResource = new LinkResource(description: linkResourceCo.description,
                topic: topic,createdBy: user,url: linkResourceCo.link)
        if (linkResource.validate()) {
            linkResource.save(flush: true)
            //pushReadingItems(linkResource)
            render ([message:"Successfully saved"]as JSON)
        } else {
            render ([error:"Resource cannot be saved"]as JSON)
        }
    }

}
