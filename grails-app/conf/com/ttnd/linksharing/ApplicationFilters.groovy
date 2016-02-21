package com.ttnd.linksharing

class ApplicationFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                def user = session['user']
                if (!user) {
                    redirect(action: 'index', controller: 'login', id: user.id)
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
            true
        }

        loginCheck(controller: '*', controllerExclude: 'login') {
            before = {

            }
            true
        }

        sessionCheck(controller: '', action: '') {
            before = {

            }

        }

    }
}
