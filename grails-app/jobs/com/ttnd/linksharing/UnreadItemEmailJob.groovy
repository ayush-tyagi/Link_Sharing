package com.ttnd.linksharing

class UnreadItemEmailJob {
def userService

    static triggers = {
    cron name:"Send Mail",cronExpression: "0 0 1 ? * MON *"
    }

    def execute(){
        log.info("com.ttnd.linksharing.UnreadItemEmailJob Execute Started at ${new Date()}")
        userService.sendMailForUnreadResources()
        log.info("com.ttnd.linksharing.UnreadItemEmailJob Execute finished at ${new Date()}")
    }
}
