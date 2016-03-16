package com.ttnd.linksharing.co

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

@Validateable
class UserCo {
    String firstName
    String lastName
    String userName
    String password
    String confirmPassword
    String email_id
    Boolean isAdmin
    Boolean isActive
    MultipartFile photo

    static constraints = {
        isActive(blank:true,nullable:true)
        isAdmin(blank:true,nullable:true)
        email_id(unique: true, blank: false, email: true)
        password(blank: false, minSize: 5)
        firstName(blank: false)
        lastName(blank: false)
        userName (blank:false , unique:true)
       /* confirmPassword(nullable: true, blank: true, validator: { confirmPassword, obj ->
            Long id = 0
            id = obj.getId()
            //println "---------------------------->>>>  ${id} ${obj.password} ${obj.confirmPassword}"
            if (!obj.id && obj.password != confirmPassword) {
                "password.mismatch.confirmPassword"
            }
        })
*/   confirmPassword(bindable: true, nullable: true, blank: true, validator: { val, obj ->
            if (obj.password != val || !val || !obj.password) {
                return 'password.do.not.match.confirm.password'
            }
        })
    }
}
