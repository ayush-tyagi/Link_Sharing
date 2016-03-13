package com.ttnd.linksharing

class ReadingItemController {

    def index() {
        render "Welcome to Reading Item"
    }

    def changeIsRead(Long resourceId, Boolean isRead) {
//        ReadingItem readingItem = ReadingItem.get(id)
        // Resource resource = Resource.get(resourceId)

        User user = session.user
        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=:isRead where r.resource.id=:resourceId " +
                "and r.user.id=${user.id}", [isRead: isRead, resourceId: resourceId])) {
            flash.message = "Success"
        } else {
            flash.error = "Updation failed"
        }
        redirect(controller: 'user', action: 'index')
    }
}
