package com.ttnd.linksharing

class ReadingItemController {

    def index() { }

    def changeIsRead(Long id,Boolean isRead){
        ReadingItem readingItem =ReadingItem.get(id)
        if(readingItem.executeUpdate("update ReadingItem as r set r.isRead=:isRead where r.id=:id", [isRead:isRead, id:id])){
    readingItem.refresh()
    render "Success"
}else{
    render "Error "
}

}
}
