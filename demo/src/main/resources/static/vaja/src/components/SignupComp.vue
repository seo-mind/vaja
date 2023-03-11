<template>
  <div>
    <div class="input-group mb-3">
      <input type="text" v-model="name" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
    </div>
    <div class="input-group mb-3">
      <input type="text" v-model="memberId" class="form-control" placeholder="ID" aria-label="ID" aria-describedby="basic-addon1">
    </div>
    <div class="input-group mb-3">
      <input type="text" v-model="email" class="form-control" placeholder="ID" aria-label="ID" aria-describedby="basic-addon1">
    </div>
    <button @click="fnSignUp">회원 가입</button>
  </div>

</template>

<script>
import axios from 'axios'

export default {
  data(){
    return {
      name :'',
      memberId :'',
      email :'',
    }
  },
  methods:{
    fnSignUp(){
      let data = {name : this.name
                 ,memberId : this.memberId 
                 ,email : this.email
                 }
      axios({url :'http://localhost/api/signup',method:'post',params : data 
      }).then( 결과 => {
       
        console.log(결과);
      })
    }
  }
}
</script>

<style>

</style>