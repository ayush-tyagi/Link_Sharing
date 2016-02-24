package com.ttnd.linksharing

import CO.ResourceSearchCo

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

    def search(ResourceSearchCo co){
        println "co : ${co.properties}"
        List<Resource> resources = Resource.search(co).list()
        render resources
    }
}
