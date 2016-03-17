package com.ttnd.linksharing

import grails.converters.JSON

class ReadingItemController {

    def index() {
        render "Welcome to Reading Item"
    }

    def changeToIsRead(Long id) {
        Boolean isRead = true
        User user = session.user
        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=:isRead where r.resource.id=:resourceId " +
                "and r.user.id=${user.id}", [isRead: isRead, resourceId: id])) {
            render(view: '/readingItem/_markAsUnread' )
        } else {
            render("Error ..")
        }
//       render("Not done")
    }
    def changeToUnread(Long id) {
//        ReadingItem readingItem = ReadingItem.get(id)
        // Resource resource = Resource.get(resourceId)
        Boolean isRead = false
        String message
        boolean status
        User user = session.user
        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=:isRead where r.resource.id=:resourceId " +
                "and r.user.id=${user.id}", [isRead: isRead, resourceId: id])) {

            render(view: '/readingItem/_markAsRead' )
        } else {
            render("Cannot mark as you need")
        }
//        redirect(controller: 'user', action: 'index')
//        render("Error .. ")
    }
}
