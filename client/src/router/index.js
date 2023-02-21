import Vue from 'vue'
import Router from 'vue-router'
import Welcome from '@/components/Welcome'
import Error from '@/components/Error'
import Home from '@/components/Home'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'Welcome',
      component: Welcome
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '/err',
      name: 'Error',
      component: Error
    },
    
  ]
})
