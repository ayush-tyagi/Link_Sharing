package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.PostVo
import grails.transaction.Transactional

@Transactional
class ResourceService {

    def serviceMethod() {

    }


    List<PostVo> search(ResourceSearchCo resourceSearchCO){

        List<PostVo> posts = []

        List<Resource> resources = Resource.search(resourceSearchCO).list()

        posts = resources?.collect{ Resource.getPostInfo(it.id) }

        return posts
    }
}
