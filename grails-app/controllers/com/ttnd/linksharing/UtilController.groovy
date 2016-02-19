package com.ttnd.linksharing

class UtilController {

    def index() {
        log.info("Sample info")
        log.warn("Sample warn")
        log.error("Sample error")
        log.fatal("Sample fatal")
     render "success"
    }
}
