import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Main from '../views/Main.vue'
import SignUp from '../views/SignUp.vue'
import User from '../views/User.vue'
import StudentList from '../views/StudentList.vue' //학생목록
import attendance from '../views/Attendance.vue'  //출석부
import studentTuition from '../views/StudentTuition.vue'   //수강료납부
import studentSeat from '../views/StudentSeat.vue' //자리배치

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Main',
    component: Main
  },
  {
    path:'/signup',
    name :'SignUp',
    component:SignUp
  },
  {
    path:'/user',
    name :'User',
    component:User
  },
  {
    path:'/studentlist',
    name :'StudentList',
    component:StudentList
  },
  {
    path:'/attendance',
    name :'attendance',
    component:attendance
  },
  {
    path:'/studenttuition',
    name :'studentTuition',
    component:studentTuition
  },
  {
    path:'/studentSeat',
    name :'studentSeat',
    component:studentSeat
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
