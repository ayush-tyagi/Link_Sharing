class UrlMappings {

	static mappings = {
        /*"/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }*/

       // "/"(view:"/index")
        "404"(view: '/404')
        "500"(view:'/error')
        "/"(controller: "login", action: "index")
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }
	}
}
