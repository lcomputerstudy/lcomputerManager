<template>
    <v-container>
        <h1>출석부</h1>
        <div>{{AttendanceList}}</div>
    </v-container>
</template>

<script>
import {mapState,mapActions} from "vuex"
export default {
    created() {
        this.$store.dispatch('AttendanceList')
    },
    computed: {
        ...mapState(["AttendanceList"])
    }
        
}
</script>