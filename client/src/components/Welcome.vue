<template>
  <div class="login">
    <div v-if="loginInfo !== null">Data from server: {{ loginInfo }}</div>
    <div>{{ serverInfo }}</div>
    <div class="login__form">
      <div class="login__form-item">
        <label for="username">username</label>
        <input
          name="username"
          type="text"
          v-model="username"
          placeholder="Enter username"
        />
      </div>

      <div class="login__form-item">
        <label for="password">password</label>
        <input
          name="password"
          type="text"
          v-model="password"
          placeholder="Enter password"
        />
      </div>

      <button
        @click="sendData(`${serverURL}/login/auth`, { username, password })"
      >
        Click
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Welcome",
  data() {
    return {
      msg: "Welcome to Your Grails & Vue.js App",
      serverInfo: {},
      loginInfo: null,
      showLinks: false,
      inputData: "",
      username: "",
      password: "",
      serverURL: process.env.VUE_APP_SERVER_URL,
    };
  },
  methods: {
    async sendData(url = "", data = {}) {
      const fetchData = await fetch(url, {
        method: "POST",
        body: JSON.stringify(data),
      });
      this.serverInfo = await fetchData.json()

      // const loginData = await fetch(`${this.serverURL}/login`);
      // this.loginInfo = await loginData.json()
    },
  },
};
</script>

<style scoped>
.login {
  max-width: 250px;

  margin: 60px auto;
}

.login__form {
  display: flex;
  flex-direction: column;
  gap: 25px;
}

.login__form-item {
  display: flex;
  flex-direction: column;
  gap: 8px;
}
</style>