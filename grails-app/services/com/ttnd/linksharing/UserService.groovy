package com.ttnd.linksharing

import grails.transaction.Transactional

@Transactional
class UserService {
  def emailService
    def serviceMethod() {

    }
    def sendUnreadItemsEmail(){
        emailService.sendMail()
    }

    List<User> getUserWithUnreadItems(){
        List<User> users = User.createCriteria().list(){
            'readingItems'{
                eq('isRead',false)
            }
        }
        users
    }

    List<Resource> getUnreadResources(User user){
    List<Resource> resources = Resource.createCriteria().list(){
        'readingItems'{
            eq('isRead',false)
        }
    }
        resources
    }

    def sendUnreadItemsEmail(User user,List<Resource> resources){

    }
}
