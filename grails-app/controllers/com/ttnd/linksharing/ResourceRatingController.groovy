package com.ttnd.linksharing

class ResourceRatingController {

    def index() {
    }

    def save(Long id, Integer score) {
        println "===============>> ${params}"
        User user = session.user
        Resource resource = Resource.get(id)
        println "---------->>>>${resource}"
        if (ResourceRating.executeUpdate("update ResourceRating " +
                "as rr set rr.score=${score} where rr.resource.id=${resource?.id}" + " and rr.user.id=${user?.id}")) {
            render "success"
        } else {
            render "Sorry"
        }
    }
}
