<script setup>
import { ref } from 'vue';
const opened = ref(false)


function handleOpen() {
  opened.value = !opened.value
}

</script>

<template>
  <div :class="['sidebar', { 'sidebar-open': opened }]">
    <div :class="['button', { 'buttonOpened': opened }]" @click="handleOpen">
      <img class="imgWhiteFilter" src="../assets/menu.svg" height="30" />
      <div :class="['buttonText', { 'buttonTextOpened': opened }]">Menú</div>
    </div>
    <div class="menuButtons"> 
      <router-link to="/registerEmergency" :class="['button', { 'buttonOpened': opened }]"> 
        <img class="imgWhiteFilter" src="../assets/add.svg" height="30" />
        <div :class="['buttonText', { 'buttonTextOpened': opened }]">Crear emergencia</div>
      </router-link>
      <router-link to="/allEmergencies" :class="['button', { 'buttonOpened': opened }]"> 
        <img class="imgWhiteFilter" src="../assets/folder.svg" height="30" />
        <div :class="['buttonText', { 'buttonTextOpened': opened }]">Todas las emergencias</div>
      </router-link>
      <router-link to="/history" :class="['button', { 'buttonOpened': opened }]"> 
        <img class="imgWhiteFilter" src="../assets/history.svg" height="30" />
        <div :class="['buttonText', { 'buttonTextOpened': opened }]">Emergencias finalizadas</div>
      </router-link>
  </div>
    <router-link to="/" :class="['button', { 'buttonOpened': opened }]"> 
      <img class="imgWhiteFilter" src="../assets/logout.svg" height="30" />
      <div :class="['buttonText', { 'buttonTextOpened': opened }]">Salir del portal</div>
    </router-link>
  </div>
</template>

<style>
.sidebar {
  box-sizing: border-box;
  padding-top: 120px;
  position: fixed;
  padding-bottom: 20px;
  display: flex;
  justify-content: space-between;
  flex-direction: column;
  min-height: 100vh;
  width: 100%;
  max-width: 70px;
  z-index: 0;
  background-color: #1769aa;
  transition: max-width 0.5s linear;
}
.sidebar-open {
  max-width: 300px;
  transition: max-width 0.5s linear;
}

.useImgContainer {
  background-color: #d5d5d5;
  height: 50px;
  width: 50px;
  border-radius: 100px;
  border: #d3d3d3 solid 2px;
}

.menuButtons {
  display: flex;
  cursor: pointer;
  flex-direction: column;
  gap: 10px;
}

.button {
  box-sizing: border-box;
  display: flex;
  justify-content: start;
  
  gap: 20px;
  padding: 10px 0px 10px 0px;
  padding-left: 20px;
  cursor: pointer;
  flex-direction: row;
}

.buttonOpened {
  padding-left: 20px;
  flex-direction: row;
}

.buttonText {
  color: #ffffff;
  font-size: 18px;
  opacity: 0;
  height: 0px;
  overflow: hidden;
  transition: opacity 0.5s ease-in-out, height 0.5s linear;
}

.buttonTextOpened {
  opacity: 1;
  height: auto;
  white-space: nowrap;
  transition: opacity 0.5s ease-in-out;
  transition-delay: 0.5;
}
.button:hover {
  background-color: #2b7dc0;
}

.openMenu{
  display: flex;
  padding: 10px 0px 10px 0px;
  gap: 10px;
  cursor: pointer;
  flex-direction: column;
}

.openMenu:hover {
  background-color: #2b7dc0;
}

.logout:hover {
  background-color: #2b7dc0;
}

.imgWhiteFilter {
  filter: invert(100%) sepia(100%) saturate(0%) hue-rotate(341deg) brightness(102%) contrast(101%);
}

@media (min-width: 420px){
  .logoTitle {
    display: block;
    font-size: 30px;
    text-align: left;
    line-height: 1;
    font-weight: 500 !important;
  }
}

.content {
  margin-left: 70px;
  padding-top: 100px;
}
</style>
