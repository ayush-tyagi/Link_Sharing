package com.ttnd.linksharing

class ApplicationFilters {

    def filters = {
//        all(controller: '*', action: '*') {
//            before = {
//             log.info("${params}")
//            }
//            after = { Map model ->
//
//            }
//            afterView = { Exception e ->
//
//            }
            true
//        }

        loginCheck(controller: '*', controllerExclude: 'login') {
            before = {
//                def user = session["user"]
////                def Session=["user"]
//
//                if (!user) {
//                    redirect(action: 'index', controller: 'login')
//                }
            }
            true
        }

        sessionCheck(controller: '', action: '') {
            before = {

            }

        }

    }
}
