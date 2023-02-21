<template>
  <div class="login-page">
    <div class="login-title">Log in to system</div>
    
    <div class="inputs-block">
      <div class="login-input input-block">
        <label for="login">Username: </label>
        <input 
          type="text" 
          placeholder="Enter your login" 
          name="login"
          class="input-field"
          :class="{ 'incorrect-input': errorForm.username }"
          v-model="username"
          @focus="errorForm.username = false"
        >
      </div>
      <div class="password-input input-block">
        <label for="password">Password: </label>
        <input 
          type="password"
          placeholder="Enter your password" 
          name="password"
          class="input-field"
          :class="{ 'incorrect-input': errorForm.password }"
          v-model="password"
          @focus="errorForm.password = false"
        >
      </div>
    </div>
    
    <button @click="checkForm" class="login-button">Log in</button>
  </div>
</template>

<script>
export default {
  name: "Welcome",
  data() {
    return {
      serverInfo: {},
      loginInfo: {},
      username: "",
      password: "",
      errorForm: {
        username: false,
        password: false,
      },
      serverURL: process.env.VUE_APP_SERVER_URL,
      message: 'none',
    };
  },
  methods: {
    async sendData(url = "", data = {}) {
      const fetchData = await fetch(url, {
        method: "POST",
        body: JSON.stringify(data),
      });
      this.serverInfo = await fetchData.json()
      if(this.serverInfo.status == 200) {
        this.$router.push({ path: '/home' })
      } else if (this.serverInfo.status == 403) {
        this.$router.push({ path: '/err' })
      }
    },
    async checkForm() {
      if(this.password.length && this.username.length) {
        await this.sendData(`${this.serverURL}/login/auth`, { username: this.username, password: this.password });
        return
      } 
      if(!this.username.length) {
        this.errorForm.username = true
      } 
      if(!this.password.length) {
        this.errorForm.password = true
      }

    },
  },
};
</script>

<style scoped>
.login-page {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.login-title {
  font-size: 2rem;
  margin-bottom: 3rem;
}
.inputs-block {
  width: 60%;
  width: fit-content;
  margin-bottom: 3rem;    
  display: flex;
  flex-direction: column;
  align-items: end;
}
.input-block {
  width: fit-content;
}
.input-block > label {
  margin-right: .5rem;
}
.input-field {
  padding: .2rem;
  background-color: rgb(241, 241, 241);
  border: .1rem black solid;
  border-radius: 2%;
}
.login-input {
  margin-bottom: .8rem;
  float: right;
}
.incorrect-input {
  border: .1rem rgb(209, 0, 0) solid;
}
</style>