package com.ttnd.linksharing

import com.ttnd.linksharing.co.DocumentResourceCo
import org.springframework.web.multipart.MultipartFile

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DocumentResourceController extends ResourceController {

    @Transactional
    def save(DocumentResourceCo co) {
        MultipartFile file = params.file
        DocumentResource documentResource = new DocumentResource()
        if (file.empty) {
            flash.error = "Invalid file"
        } else {
            String filePath = "${grailsApplication.config.linksharing.documents.folderPath}/${UUID.randomUUID()}.pdf"
            documentResource.contentType = co.file.contentType
            documentResource.filePath = filePath
            documentResource.description = co.description
            documentResource.createdBy = session.user
            documentResource.topic = Topic.get(co.topic)
            if (documentResource.save(flush: true, failOnError: true)) {
                File savedFile = new File(filePath)
                co.file.transferTo(savedFile)
                pushReadingItems(documentResource)
                flash.message = "File saved successfully"
            } else {
                flash.error = "File couldn't be saved"
//                println ">>>>>>>>>>>>>>>>>>>>>>" + documentResource.errors.allErrors
            }
        }
//        render("asdasdasdasd")


        redirect(controller: "user", action: "index")
    }

    def download(Long id) {
        User user = session.user
        DocumentResource documentResource = (DocumentResource) Resource.get(id)
        println "----------docres--------------->>>>>>${documentResource}"
        if (documentResource && documentResource.canViewBy(user)) {
            def file = new File(documentResource.filePath)
            if (file.exists()) {
                response.setContentType(Constants.DOCUMENT_CONTENT_TYPE)
                response.setHeader("Content-disposition", "attachment;filename=${documentResource.fileName}")
                response.outputStream << file.bytes
            } else {
                flash.error = "Desired resource doesnt exist"
                render flash.error
            }
        } else {
            render "Permission denied..."
        }
//        redirect(controller: 'resource', action: 'show', params: [id: id])
    }

}
