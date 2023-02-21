<template>
    <div class="error-wrapper">
        <div class="error-message">
            Your username or password are incorrect
        </div>
        <button @click="toLogin" class="error-button">
            Try again
        </button>
    </div>
</template>

<script >
export default {
  name: "ErrorPage",
  data() {
    return {
    };
  },
  methods: {
    toLogin() {
        this.$router.push({ path: '/' })
    }
  }
}
</script>

<style scoped>
    .error-wrapper {
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 1rem;
    }
</style>