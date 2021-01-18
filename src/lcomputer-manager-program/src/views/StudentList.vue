<template>
    <v-container>
        <h1>학생명단</h1>
         <v-simple-table>
          <tr style="font-weight:900;">
            <td>IDX</td>
            <td>NO</td>
            <td>NAME</td>
            <td>BIRTH</td>
            <td>GENDER</td>
            <td>PHONE</td>
            <td>EMAIL</td>
            <td>ADDRESS</td>
            <td>CLASS</td>
            <td>Start</td>
            <td>endEvent</td>
            <td>end</td>
            <td>counsel</td>
            <td>Marketing</td>
            <td>memo</td>
            <td>subject</td>
          </tr>
         <tr v-for="(item, i) in StudentList" :key="i">
            <td> <span v-if="temp == item.s_idx" ><input type="text"></span>
                <span v-else>{{item.s_idx}}</span>
            </td>
            <td> <span v-if="temp == item.s_idx" ><input type="text" class="inputa"></span>
                <span v-else>{{item.s_no}}</span></td>
            <td>{{item.s_name}}</td>
            <td>{{item.s_birth}}</td>
            <td>{{item.s_gender}}</td>
            <td>{{item.s_phone}}</td>
            <td>{{item.s_email}}</td>
            <span v-if="temp == item.s_idx">
              <v-btn  @click="ddd()">수정완료</v-btn>
            </span>
            <span  v-else>
            <v-btn  @click="aaa(item.s_idx)">수정</v-btn>
            </span>
            <td>{{item.s_address}}</td>
            <td>{{item.s_class}}</td>
            <td>{{item.s_startDate}}</td>
            <td>{{item.s_endEventDate}}</td>
            <td>{{item.s_endDate}}</td>
            <td>{{item.s_counselDate}}</td>
            <td>{{item.s_Marketing}}</td>
            <td>{{item.s_memo}}</td>
            <td>{{item.s_subject}}</td>
         </tr>
         </v-simple-table>
    </v-container>
</template>
<style scoped>
table {
    margin:50px auto;
    border-collapse:collapse;
    text-align: center;
    overflow-x:scroll;
  }
  table tr td {
    border:1px solid #818181;
    padding:5px;
  }
</style>
<script>
import {mapState,mapActions} from "vuex"
export default {
  data() {
    return {
      
    }
  },
    created() {
        this.$store.dispatch('StudentList')
        this.$store.dispatch('ddd')
    },
    computed: {
        ...mapState(["StudentList","temp"])

    },
    methods: {
      aaa(index) {
        this.temp=index
      }
      
    }
        
}
</script>