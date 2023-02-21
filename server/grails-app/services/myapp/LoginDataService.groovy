package myapp

import grails.gorm.services.Service

@Service(Login)
interface LoginDataService {
    Login save(String username, String password)
}