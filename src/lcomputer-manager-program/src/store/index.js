import Vue from 'vue'
import Vuex from 'vuex'
import Route from '../router/index'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    Userinfo:{User_Id:null,User_Name:null,User_auth:[],User_token:null},
    boardlist:[],
    board_detail:[],
    StudentList:[],
    AttendanceList:[],
    StudentTuition:[],
  },
  mutations: {
    SET_USER(state, data) {
      state.Userinfo.User_Id = data.username
      state.Userinfo.User_Name = data.name
      state.Userinfo.User_auth = data.authorities
      state.Userinfo.User_token = data.token
      Route.push("/user")
    },
    ReadStudentList(state,data) {
      state.StudentList = data
    },
    SetUserRefresh(state,data) {
      state.Userinfo.User_Id = data.username
      state.Userinfo.User_Name = data.name
      state.Userinfo.User_auth = data.authorities
      state.Userinfo.User_token = data.token
    },
    INSERT_TOKEN(state) {
      state.Userinfo.User_token = localStorage.getItem("token")
    },
    ReadAttendanceList(state,data) {
      state.AttendanceList=data
    },
    ReadStudentTuition(state,data) {
      state.StudentTuition=data
    },
    ddd() {
     
    }
  },
  actions: {
    SignUp({commit},payload) {
      console.log(payload)
      return new Promise((resolve, reject) => {
          axios.post('http://localhost:9000/api/auth/signup', payload)
              .then(Response => {
                  console.log(Response.data)
                  if(Response.data === "success") {
                    Route.push("/")
                  }
              })
              .catch(Error => {
                  console.log('error')
                  reject(Error)
                  alert("아이디가 중복")
              })
      })
     },
     
    loginProcess({ commit }, payload) {
      console.log(payload)
      return new Promise((resolve, reject) => {
          axios.post('http://localhost:9000/api/auth/signin', payload)
              .then(Response => {
                  console.log(Response.data)
                  if (Response.data.username != null) {
                      axios.defaults.headers.common['Authorization'] = `Bearer ${Response.data.token}`
                      localStorage.setItem("token",Response.data.token)
                      commit('SET_USER', Response.data)      
                  }
              })
              .catch(Error => {
                  console.log('error')
                  reject(Error)
              })
      })
   },
   StudentList({commit,state}) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.get('http://localhost:9000/api/admin/studentlist')
          .then(Response => {
            console.log(Response.data)
             commit('ReadStudentList',Response.data)
          })
          .catch(Error => {
            // console.log(Error)
              console.log('studentlist_error')
              Route.push("/")
          })
  })
  },
  AttendanceList({commit,state}) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.get('http://localhost:9000/api/admin/attendancelist')
          .then(Response => {
            console.log(Response.data)
              commit('ReadAttendanceList',Response.data)
          })
          .catch(Error => {
            // console.log(Error)
              console.log('attendancelist_error')
              Route.push("/")
          })
  })
  },
  StudentTuition({commit,state}) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.Userinfo.User_token}`
      axios.get('http://localhost:9000/api/admin/studenttuition')
          .then(Response => {
            console.log(Response.data)
              commit('ReadStudentTuition',Response.data)
          })
          .catch(Error => {
            // console.log(Error)
              console.log('studenttuition_error')
              Route.push("/")
          })
  })
  },
  UnpackToken({commit}) {
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem("token")}`
      axios.get('http://localhost:9000/api/auth/unpackToken')
          .then(Response => {
            console.log(Response.data)
            commit('SetUserRefresh',Response.data)
          })
          .catch(Error => {
            console.log(Error)
              console.log('unpackToken_error')
          })
  })
  },
  ddd({commit}) {
    commit('ddd')
  }
  },
  modules: {
  }
})
