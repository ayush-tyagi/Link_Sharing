package com.ttnd.linksharing

import com.ttnd.linksharing.co.TopicSearchCo
import com.ttnd.linksharing.com.ttnd.linksharing.vo.TopicVo
import dto.EmailDto
import grails.transaction.Transactional
import org.springframework.web.context.request.RequestContextHolder

@Transactional
class TopicService {

    def messageSource
    def grailsApplication
    def groovyPageRenderer
    def emailService
    def subscriptionService

    def serviceMethod() {

    }

    List<Topic> search(TopicSearchCo topicSearchCo) {
        List<TopicVo> createdTopicsList = []

        if (topicSearchCo.id) {
            User user = topicSearchCo.getUser()

            List<Topic> topicList = Topic.createCriteria().list(max: topicSearchCo.max) {
                eq('createdBy.id', topicSearchCo.id)

                if (topicSearchCo.visibility)
                    eq('visibility', topicSearchCo.visibility)
            }

            topicList.each {
                topic ->
                    createdTopicsList.add(new TopicVo(id: topic.id,
                            name: topic.name, visibility: topic.visibility, createdBy: topic.createdBy))
            }

        }

        return createdTopicsList
    }

    Boolean invite(String topicName, String email) {
        Topic topic = Topic.findByName(topicName)
        if (topic) {
//            println "---------->>>>>>>>>>>>>>>${topic}"
            User user = User.findByEmail_id(email)
//            println "==================<><><><><>${user}"
            if (user) {
                def session = RequestContextHolder.currentRequestAttributes().getSession()
                EmailDto emailDTO = new EmailDto(
                        to: [email],
                        subject: "Invitation for Topic",
                        content: groovyPageRenderer.render(template: '/topic/invite', model: [userName : session.user.firstName,
                                                                                              topicName: topic.name,
                                                                                              email    : email,
                                                                                              topicId  : topic.id,
                                                                                              base     : grailsApplication.config.grails.serverBaseURL])
                )
                if (emailService.sendMail(emailDTO)) {
                    return true
                }
            }
            return false
        }
    }

    Subscription joinTopic(Topic topic, User user) {
        if (topic && user) {
            return subscriptionService.saveSubscription(new Subscription(user: user, topic: topic))
        }
        return null
    }

    Boolean changeTopicName(String name,Long id){
    Topic topic = Topic.get(id)
        Boolean retun
        if(topic){
            topic.name=name
            topic.save(flush: true)
            println "inside if"
            retun = true
        }else {
            retun = false
        }
        return retun
    }
}
