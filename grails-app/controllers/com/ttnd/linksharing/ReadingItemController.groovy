package com.ttnd.linksharing

import grails.converters.JSON

class ReadingItemController {

    def index() {
        render "Welcome to Reading Item"
    }

    def changeIsRead(Long resourceId, Boolean isRead) {
//        ReadingItem readingItem = ReadingItem.get(id)
        // Resource resource = Resource.get(resourceId)
        String message
        boolean status
        User user = session.user
        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=:isRead where r.resource.id=:resourceId " +
                "and r.user.id=${user.id}", [isRead: isRead, resourceId: resourceId])) {
         message = "Successfully changed"
            status = true
        } else {
            message = "Unsuccessful attempt"
            status = false
        }
//        redirect(controller: 'user', action: 'index')
       render([message,status]as JSON)
    }
}
