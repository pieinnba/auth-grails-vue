package myapp

import grails.rest.Resource

@Resource(uri = '/login')
class Login {
    String username
    String password
}
