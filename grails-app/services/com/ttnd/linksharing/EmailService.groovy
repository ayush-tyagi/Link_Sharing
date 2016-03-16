package com.ttnd.linksharing

import dto.EmailDto
import grails.transaction.Transactional

@Transactional
class EmailService {

    def mailService

    def serviceMethod() {

    }

    def sendMail(EmailDto emailDto){
        mailService.sendMail {
            to emailDto.to.toArray()
            subject emailDto.subject
            if(emailDto.content){
                html emailDto.content
            }
            else{
                body(view:emailDto.view,model:emailDto.model)
            }
        }
    }
    def sendUnreadResourcesEmail(User user,List<Resource> resources){

    }
}
