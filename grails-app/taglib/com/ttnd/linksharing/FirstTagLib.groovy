package com.ttnd.linksharing

import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
import enums.L_Visibility

class FirstTagLib {
    //static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "my"

    def showAdmin = { attrs, body ->

        Boolean isAdmin = Boolean.valueOf(attrs.isAdmin)
        if (isAdmin) {
            out << body()
        }

    }
    def showList = {
        List<User> user = User.list()
        out << render(template: '/user/myTemplate', model: [user: user])
    }

    def showMarkReadLink = { attrs, body ->
        if (session.user) {
            if (ReadingItem.get(attrs.id).isRead) {
                out << "<a href='#'>Mark as unread </a>"
            } else {
                out << "<a href='#'>Mark as read </a>"
            }
        }
    }

    def trendingTopics = { attrs, body ->
        List<TopicVo> trendingTopics = Topic.getTrendingTopics()
        out << render(template: '/topic/trendingTopics', model: [trendingTopics: trendingTopics])
    }

    def topPosts = { attrs, body ->
        List<Resource> resources = Resource.getTopPosts()
        out << render(template: '/readingItem/topPosts', model: [resources: resources])
    }

    def isLinkOrDoc = { attrs, body ->
        if (Resource.isLinkResourceOrDocResource(attrs.id) == "LinkResource") {
            LinkResource linkResource = Resource.get(attrs.id)
            out << "<a href=\"${linkResource.url}\" target=\"_blank\" style=\"text-decoration:underline;font-size:13px\"> Link </a>"
        } else if (Resource.isLinkResourceOrDocResource(attrs.id) == "DocumentResource") {
            String ref = createLink(controller: 'documentResource', action: 'download', params: [id: attrs.id])
            out << "<a href=${ref} > Download </a>"
        } else {
            out << "<h6 style=\"text-decoration:underline;font-size:13px\">Not Found<h6>"
        }
    }

    def canDeleteResource = { attrs, body ->
        User user = session.user
        if (user.canDeleteResource(attrs.id)) {
            out << g.link(controller: "resource", action: "delete", params: [id: attrs.id], "Delete")
        }
    }

    def markAsRead = { attrs, body ->
        if (session.user) {
           /* String ref = createLink(controller: 'readingItem', action: 'changeIsRead', params: [resourceId: attrs.id,
                                                                                             isRead    : !attrs.isRead])
            */
            if (!attrs.isRead) {
                out << render(template: '/readingItem/markAsRead',model: [resourceId:attrs.id])
            } else {
                out << render(template: '/readingItem/markAsUnread',model: [resourceId:attrs.id])
            }

        }

    }

    def showSubscribe = { attrs, body ->
        User user = session.user
        if (user && attrs.topicId) {
            if (user.isSubscribe(attrs.topicId)) {
                Topic topic = Topic.get(attrs.topicId)
                if (user?.isAdmin || user.equals(topic.createdBy)) {
//                String ref = createLink(controller: 'subscription',action: 'delete',params: [topicId: attrs.topicId])
                    out << render(template: '/subscription/forAdminOrCreator', model: [topicId: attrs.topicId])
                }
            } else {
//                String ref = createLink(controller: 'subscription',action: 'save',params: [topicId:attrs.topicId])
                out << render(template: '/subscription/normalUser', model: [topicId: attrs.topicId])
            }
        }
    }


    def subscriptionCount = { attrs, body ->
        Topic topic = Topic.get(attrs.topicId)
        int count = Subscription.countByTopicOrUser(topic, session.user)
        out << count
    }

    def resourceCount = { attrs, body ->
        Topic topic = Topic.get(attrs.topicId)
        int count = Resource.countByTopic(topic)
        out << count
    }

    def topicCount = { attrs, body ->
        User user = session.user
        int count = Topic.countByCreatedBy(user)
        out << count
    }

    def userImage = { attrs, body ->
        Long userId = attrs.userId
        def height = attrs.height
        def width = attrs.width
        def tagClass = attrs.class
        out << "<img src='${createLink(controller: 'user', action: 'image', params: [id: userId])}' " + "class='${tagClass}' " +
                "height='${height}' width='${width}' />"
    }
    def canUpdateTopic = { attrs, body ->
        User user = session.user
        Topic topic = Topic.get(attrs.topicId)
        L_Visibility visibility = topic.visibility
        Subscription subscription = Subscription.findByTopicAndUser(topic, user)
        if(subscription){
        if (user?.isAdmin || topic.createdBy == user) {
            out << render(template: '/resource/adminSeriousnessVisibility',
                    model: [subscription: subscription,visibility: visibility,topicId: attrs.topicId])
        } else {
            out << "<my:showSeriousness topicId=\"${attrs.topicId}\" />"
        }}
    }

    def showSeriousness = { attrs, body ->

        Topic topic = Topic.get(attrs.topicId)
        L_Visibility visibility = topic.visibility
        out << render(template: '/subscription/normalVisibility',
                model: [visibility:visibility,topicId: attrs.topicId])
    }

    def activateDeacivate = { attrs,body ->
        User user = User.get(attrs.id)
        if(user.isActive){
            out<<"<g:link name=\"active\" data-id=\"${attrs.id}\" onclick=\"deactivateUser(${user.id});\">Deactivate</g:link>"
        }else{
            out<<"<g:link name=\"deactive\" data-id=\"${attrs.id}\" onclick=\"activateUser(${user.id});\">Activate</g:link>"
        }
    }
}

