package com.ttnd.linksharing


import com.ttnd.linksharing.co.ResourceSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.RatingInfoVo
import enums.L_Visibility
import org.hibernate.criterion.CriteriaSpecification

abstract class Resource {
    String description;
    User createdBy;
    Topic topic;
    Date lastUpdated;
    Date dateCreated;
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


}



