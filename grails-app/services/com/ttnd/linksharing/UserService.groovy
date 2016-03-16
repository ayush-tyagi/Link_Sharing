package com.ttnd.linksharing

import dto.EmailDto
import grails.transaction.Transactional
import org.springframework.web.context.request.RequestContextHolder

@Transactional
class UserService {
    def emailService
    def groovyPageRenderer
    def grailsApplication


    def sendMailForUnreadResources() {
        List<User> users = User.createCriteria().list() {
            'readingItems' {
                eq('isRead', false)
            }
        }
        users.each { user ->
            String email = user.email_id
            List<Resource> resources = getUnreadResources(user)
            if(resources) {
                EmailDto emailDTO = new EmailDto(
                        to: [email],
                        subject: "Unread Topics on LinkSharing",
                        content: groovyPageRenderer.render(template: '/readingItem/unreadingItems',
                                model: [user     : user,
                                        resources: resources,
                                        base     : grailsApplication.config.grails.serverBaseURL])
                )
                if (emailService.sendMail(emailDTO)) {
//                    render("Mail sent")
                }

            }
        }
    }

    List<Resource> getUnreadResources(User user) {
        List<Resource> resources = ReadingItem.createCriteria().list() {
            'projections'{
                property('resource')
            }
            eq('isRead',false)
            eq('user',user)
        }
        resources
    }


}
