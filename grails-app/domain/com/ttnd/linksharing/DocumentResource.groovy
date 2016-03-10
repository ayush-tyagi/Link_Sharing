package com.ttnd.linksharing

class DocumentResource extends Resource {

    String filePath
    String contentType
    String fileName
    static transients =['contentType','fileName']
    static constraints = {
//         contentType(matches:Constants.DOCUMENT_CONTENT_TYPE)/**/
        filePath(blank: false, nullable: true)
        contentType(bindable: true, validator: {
            value -> return value.equals(Constants.DOCUMENT_CONTENT_TYPE)
        })
    }
    String toString(){
        "Document file Path -->${filePath}"
    }


    String getFileName()
    {
        List filePath=filePath.split("/")
        filePath.last()
    }
    Boolean deleteFile(){
        Boolean isDelete = new File(this.filePath).delete()
        if(isDelete){
            this.delete(flush: true)
            return true
        }else {
            return false
        }
    }


}
