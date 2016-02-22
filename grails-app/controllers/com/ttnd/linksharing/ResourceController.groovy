package com.ttnd.linksharing

class ResourceController {

    def index() { }

    def delete(long id){
    Resource resource = Resource.load(id)
        if(resource.delete()){
            render "Successful Deletion"
        }else{
            log.info("${resource.errors.allErrors}")
        }
    }
}
