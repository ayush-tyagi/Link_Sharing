package com.ttnd.linksharing

class FirstTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace ="my"

    def showAdmin= { attrs, body ->

        Boolean isAdmin = Boolean.valueOf(attrs.isAdmin)
        if (isAdmin) {
            out << body()
        }

    }
        def showList={
            List<User> user=User.list()
            out<< render(template:'/user/myTemplate',model: [user:user])
        }

}
