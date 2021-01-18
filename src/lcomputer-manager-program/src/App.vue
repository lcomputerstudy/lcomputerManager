<template>
  <v-app id="inspire">
    <v-app-bar
      app
      color="white"
      flat
    >
      <v-avatar
        :color="$vuetify.breakpoint.smAndDown ? 'grey darken-1' : 'transparent'"
        size="32"
      ></v-avatar>

      <v-tabs
        centered
        class="ml-n9"
        color="grey darken-1"
      >
        <v-tab router :to="{name:'Main'}">MAIN</v-tab>
        <v-tab router :to="{name:'StudentList'}">학생 명단</v-tab>
        <v-tab router :to="{name:'attendance'}">출석부</v-tab>
        <v-tab router :to="{name:'studentTuition'}">수강료 납부</v-tab>
        <v-tab router :to="{name:'studentSeat'}">자리배치</v-tab>
        <v-tab router :to="{name:''}">장부</v-tab>
        <v-tab router :to="{name:''}">동영상</v-tab>
      </v-tabs>

      <v-avatar
        class="hidden-sm-and-down"
        color="grey darken-1 shrink"
        size="32"
      ></v-avatar>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container fluid>
        <v-row>
          <v-col
            cols="12"
            sm="12"
          >
            <v-sheet
              min-height="70vh"
              rounded="lg"
            >
              <router-view/>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>
<style scoped>
.container {
  margin-left:0;
  margin-right:0;
}
</style>
<script>

import {mapMutations, mapState} from "vuex"
  export default {
    data: () => ({
    }),
    computed: {
      ...mapState(["Userinfo"])
    },
    created() {
      if(this.Userinfo.User_token === null && localStorage.getItem("token") !== null) {
        this.$store.commit("INSERT_TOKEN"),
        this.$store.dispatch('UnpackToken')
      }
    }
  }
</script>