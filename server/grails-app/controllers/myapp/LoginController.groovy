package myapp

import grails.rest.*
import grails.converters.*
import myapp.Login


class LoginController {
    LoginDataService LoginDataService

	static responseFormats = ['json', 'xml']
    static allowedMethods = [auth: "POST"]
	
    def index() {
        // respond Login.list()
     }

    def auth() {
        for( item in Login.list()) {
            if(request.JSON.username.equals(item.username)) {
                if(request.JSON.password.equals(item.password)) {
                    respond([status: 200])
                    return
                }
            } else {
                respond([status: 403])
            }
        }
    }
}
