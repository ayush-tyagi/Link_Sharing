package com.ttnd.linksharing

import CO.ResourceSearchCo

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

    def search(ResourceSearchCo co){
        println "co : ${co.properties}"
        List<Resource> resources = Resource.search(co).list()
        render resources
    }
}
