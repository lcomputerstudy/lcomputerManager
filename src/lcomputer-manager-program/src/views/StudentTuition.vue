<template>
    <v-container>
        <h1>수강료납부</h1>
        {{StudentTuition}}
    </v-container>
</template>
<script>
import {mapState,mapActions} from "vuex"
export default {
    created() {
        this.$store.dispatch('StudentTuition')
    },
    computed: {
        ...mapState(["StudentTuition"])
    }
        
}
</script>