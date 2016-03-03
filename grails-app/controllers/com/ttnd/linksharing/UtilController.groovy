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

    def first(){
       flash.message = "This is First Message"
        render "${flash.message}"
        forward(uri:"util/second" )
    }
    def second(){
        render "${flash.message}"
        forward(controller:'util' ,action:'third' )
    }
    def third(){
     render "${flash.message}"
    }

    def hell(){
        render "Kon h tu"
    }
}
