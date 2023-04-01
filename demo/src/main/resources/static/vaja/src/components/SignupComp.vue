<template>
  <div>
    <div class="input-group mb-3">
      <input type="text" v-model="name" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
    </div>
    <div class="input-group mb-3">
      <input type="text" v-model="memberId" class="form-control" placeholder="memberId" aria-label="memberId" aria-describedby="basic-addon1">
    </div>
    <div class="input-group mb-3">
      <input type="text" v-model="email" class="form-control" placeholder="email" aria-label="email" aria-describedby="basic-addon1">
    </div>
    <div class="input-group mb-3">
      <input type="text" v-model="password" class="form-control" placeholder="PASSWORD" aria-label="PASSWORD" aria-describedby="basic-addon1">
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
      password :'',
    }
  },
  methods:{
    fnSignUp(){
      let data = {name : this.name
                 ,memberId : this.memberId 
                 ,email : this.email
                 ,password : this.password
                 };
      const config = {"Content-Type": 'application/json'};
      const json = JSON.stringify(data);
      axios.post('http://localhost/api/test/signup', json ,  { headers: config
      }).then( 결과 => {
       
        console.log(결과);
      })
    }
  }
}
</script>

<style>

</style>