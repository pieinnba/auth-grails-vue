<template>
  <div id="app">  
    <div class="wrapper">
      <div class="modal">
        <RouterView />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
  .wrapper {
    min-width: 100%;
    height: 100vh;
    background-color: rgb(190, 190, 190);
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .modal {
    min-width: 30rem;
    min-height: 20rem;
    background-color: rgb(255, 255, 255);
    padding: 1rem;
    border: .1rem rgb(255, 255, 255) solid;
    border-radius: 1%;
    display: flex;
    align-items: center;
  }

</style>
