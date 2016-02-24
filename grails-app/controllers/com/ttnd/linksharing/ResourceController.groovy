package com.ttnd.linksharing

class ResourceController {

    def index() { }

    def delete(Long id){
        Resource resource = Resource.load(id)
        if(resource){
        try{
            resource.delete(flush: true)
            render "Successful Deletion"
        }
        catch(Exception e){
            render "Unsuccessful"
        }}else{
            render "Not Found"
        }
    }
}
