package dto

class EmailDto {
    List<String> to
    String view
    String subject
    Map model
    String content

    /*static constraints={
        to(nullable:false,blank:false)
        view(nullable:false,blank:false)
        subject(nullable:false,blank:false)
        model(nullable:true)
    }*/
}
