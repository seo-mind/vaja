<template>
  <div>
    <div class="input-group mb-3">
      <input type="text" :model="name" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
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

    }
  },
  methods:{
    fnSignUp(){
      let data = {name : '전달데이터'
                , memberId:'testId'
                  }
      axios.post('http://localhost/api/signup',JSON.stringify(data) , {
        headers: { "Content-Type": `application/json`}
      }).then( 결과 => {
       
        console.log(결과);
      })
    }
  }
}
</script>

<style>

</style>