package com.ttnd.linksharing
import com.ttnd.linksharing.co.ResourceSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.RatingInfoVo
import enums.L_Visibility

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

        if(co.q){

            co.visibility = L_Visibility.PUBLIC
        List<Resource> resources = Resource.search(co).list()
            render resources
        }
    }

    def show(Long id){
        println "____>>>>>>>>>>>${id}"
        Resource resource = Resource.get(id)
        if(resource){
            RatingInfoVo ratingInfoVo = resource.getRatingInfoVo()
         render "${ratingInfoVo}"
        }else{
            flash.error = "Resource not found"
            redirect(uri:'/')
        }
    }
}
