package com.ttnd.linksharing.co

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

/**
 * Created by ayush on 10/3/16.
 */
@Validateable
class DocumentResourceCo {
    String description
    MultipartFile file
    Long topic
}
