package com.ttnd.linksharing

class UtilController {

    def index() {
        List list = User.list()
        render view: 'util', model: [list: list]
    }
//        log.info("Sample info")
//        log.warn("Sample warn")
//        log.error("Sample error")
//        log.fatal("Sample fatal")
//     render "success"
//    }
    def save(User user){
        if(user?.hasErrors()){
            render view:'util',model:[user:user]
        }else{
            render "Saved"
        }
    }


}
