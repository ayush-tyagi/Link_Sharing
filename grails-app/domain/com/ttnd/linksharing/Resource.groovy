package com.ttnd.linksharing


import com.ttnd.linksharing.co.ResourceSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.PostVo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.RatingInfoVo
import enums.L_Visibility
import org.hibernate.criterion.CriteriaSpecification

abstract class Resource {
    String description
    User createdBy
    Topic topic
    Date lastUpdated
    Date dateCreated
    static hasMany = [readingItems: ReadingItem, resourceRatings: ResourceRating]
    static belongsTo = [topic: Topic]
    static transients = ['ratingInfoVo']
    static mapping = {
        description(type: 'text')
    }

    static constraints = {
    }

    static namedQueries = {
        search { ResourceSearchCo co ->
            if (co.topicId) {
                'topic' {
                    eq('id', co.topicId)
                    eq('visibility', co.visibility)
                }
            }
        }
    }

    String toString() {
        return "${topic.name}"
    }

    RatingInfoVo getRatingInfoVo() {
        List result = ResourceRating.createCriteria().get {

            'projections' {
                count('score')
                avg('score')
                sum('score')
            }
        }

        RatingInfoVo ratingInfoVo = new RatingInfoVo(totalVotes: result[0], averageScore: result[1], totalScore: result[2])
        println "-------->${ratingInfoVo}"
        ratingInfoVo

    }

    static List<Resource> getTopPosts()
    {
        List list = ResourceRating.topPost()
        List<Resource> resources = Resource.getAll(list)
        resources
    }

    static String isLinkResourceOrDocResource(Long id){
      Resource resource = Resource.get(id)
        if(resource.instanceOf(LinkResource)){
            return "LinkResource"
        }else if(resource.instanceOf(DocumentResource)){
            return "DocumentResource"
        }
        return "Not Found"
    }

   /* Boolean canViewBy(User user){
      Resource resource = Resource.get(id)
        if(resource.topic.canViewedBy(topic.id)){
        true
        }else{
            false
        }
    }*/
     Boolean canViewBy(User user) {
        if (this.topic.canViewedBy(user)){
            return true
        }
         return false
    }


    def deleteFile(){
        log.info("Will be implemented in subClass")
    }


    public static PostVo getPostInfo(Long id) {

        PostVo postVO = null

        createCriteria().get {
            eq('id', id)
        }.each
                {
                    resourceInfo ->
                        postVO = new PostVo(userId: resourceInfo.createdBy.id, topicId: resourceInfo.topic.id, resourceId: resourceInfo.id, user: resourceInfo.createdBy.name,
                                userName: resourceInfo.createdBy.userName, topicName: resourceInfo.topic.name, description: resourceInfo.description,
                                url: resourceInfo.class.equals(LinkResource) ? resourceInfo.url : null, filePath: resourceInfo.class.equals(DocumentResource) ? resourceInfo.filePath : null,
                                createdDate: resourceInfo.dateCreated)
                }

        return postVO
    }
}



