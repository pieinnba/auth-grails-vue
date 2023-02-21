package myapp

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    LoginDataService loginDataService

    def init = { servletContext ->
        log.info "Loading database..."
        Login field1 = loginDataService.save("admin", "1234")
        Login field2 = loginDataService.save("user", "5678")

    }
    def destroy = {
    }
}
