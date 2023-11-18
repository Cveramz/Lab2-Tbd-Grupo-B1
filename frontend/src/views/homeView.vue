<script setup>

</script>

<template>
  <main>
    <div class="general">
      <div class="content">
        <img class="image" src="./media/logodgt.png"/>
        <div class="header">Voluntariado Usach</div>
        <div class="headerDescription" v-if="!register">Inicie sesión para entrar al portal</div>
        <div class="headerDescription" v-else>Complete los campos para registrarse</div>
        <div class="inputContainers" v-if="!register">
          <input type="email" v-model="username" placeholder="Correo institucional" />
          <input type="password" v-model="password" placeholder="Contraseña" />
          <button class="sessionButton" @click="login"> Iniciar Sesión </button>
        </div>
        <div class="inputContainers" v-else>
          <input type="email" v-model="usernameRegister" placeholder="Correo institucional" />
          <input type="password" v-model="passwordRegister" placeholder="Contraseña" />
          <input type="password" v-model="passwordRegisterConfirmation" placeholder="Repetir Contraseña" />
          <button class="sessionButton" @click="addUser"> Registrarse </button>
        </div>
        <div class="alsoButtons">
          <div class="alsoButton" @click="handleChange" v-if="!register">Registrarse</div>
          <div class="alsoButton" @click="handleChange" v-else>Iniciar Sesión</div>

          
        </div>
      </div>
    </div>
  </main>
</template>

<script>

import axios from 'axios';

//Redireccionamientos
//Usuario normal
function redireccionarATareas() {
  window.location.href = '/allEmergencies';
}

function isEmail(email){
  const regex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
  return regex.test(email);
}

function quitarArroba(email){
  const aux = email.split("@");
  return aux[0];
}

function generarNumeroAleatorio() {
  return Math.floor(Math.random() * 10000001);
}

export default {
  data() {
    return {
      username: '',
      password: '',
      loggedIn: false,
      register: false,
      usernameRegister: "",
      passwordRegister: "",
      passwordRegisterConfirmation: "",
    }
  },
  methods: {
    async login(){
      // Enviar datos a backend
      const usuario = {
        "email": this.username,
        "password": this.password
      };
      try {
        const respuesta = await axios.get(import.meta.env.VITE_BASE_URL + `/coordinador/login/${this.username}/${this.password}`);
        //Para redireccionar hacia el sector de tareas
        if(respuesta.data){
          if(respuesta.data.length === 0){
            alert("Credenciales no validas")
            return;
          }
          localStorage.setItem("login", JSON.stringify(this.username));
          console.log(respuesta.data[0]);
          console.log(respuesta.data);
          console.log(respuesta.data[0].id)
          localStorage.setItem("idUsuario", JSON.stringify(respuesta.data[0].id));
          redireccionarATareas();
        } else {
          alert("¡Credenciales no validas!");
        }
      } catch(error){
        alert("No se genera conexión con el servidor")
      }
     
    },
    handleChange() {
      this.register = !this.register
    },


    async addUser(){
      //Envia datos del registro al backend
      if(!isEmail(this.usernameRegister)){
        alert("Se necesita proporcionar un email valido");
        return;
      }
      if(this.passwordRegister == this.passwordRegisterConfirmation){
        if(this.usernameRegister != "" & this.passwordRegister != ""){
          const nuevo_usuario = {
            nombre_coordinador: quitarArroba(this.usernameRegister),
            email_coordinador: this.usernameRegister,
            password_coordinador: this.passwordRegister,
            id_coordinador: generarNumeroAleatorio(),
          }
          try {
            const registro = await axios.post(import.meta.env.VITE_BASE_URL + "/coordinador", nuevo_usuario);
            alert("Usuario creado con exito");
            this.register = !this.register;
          } catch(error){
            alert("No se ha logrado llevar a cabo el registro")
          }
        }
        else{alert("No hay datos ingresados")}
      }
      else{alert("Las contraseñas no coinciden")}
    }
  }
}
</script>

<style scoped>
.general {
  background-image: url("./media/VolWallpaper.jpg"); 
  
  height: 100vh;
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;

  display: flex;
  justify-content: center;
  align-items: center;
  align-content: center;
}

.image {
  height: 150px;
}
.content {
  box-sizing: border-box;
  padding: 10px;
  background-color: #f5f5f5f3;
  display: flex;
  flex-direction: column;
  align-items: center;

  min-width: 300px;
  max-width: 500px;
  width: 100%;
  margin: 0px 10px 0px 10px;
  min-height: 500px;
  max-height: 550px;
  height: 100%;
  
  border-radius: 10px;
}

.header {
  text-align: center;
  line-height: 1;
  font-size: 40px;
  font-weight: 500 !important;
}

.headerDescription {
  font-size: 16px;
  margin-bottom: 20px;
}
.inputContainers {
  display: flex;
  gap: 1px;
  width: 100%;
  max-width: 400px;
  flex-direction: column;
}

input {
  height: 50px;
  box-sizing: border-box;

  padding: 10px !important;
  font-size: 16px;
  border-radius: 4px;
  outline: none;
  border: #cdcdcd solid 3px;
  transition: border 0.2s;
}

input:hover {
  border: #bbbbbb solid 3px;
  transition: border 0.2s;
}

input:focus {
  border: #888888 solid 3px;
  transition: border 0.2s;
}

.alsoButtons {
  display: flex;
  width: 400px;
  width: 100%;
  max-width: 400px;
  justify-content: space-between;
}

.sessionButton{
  height: 50px;
  background-color: #1769aa;
  color: #f5f5f5;
  font-size: 16px;
  font-weight: 500;
  border: #1769aa solid 2px;
  border-radius: 3px;
  cursor: pointer;
  transition: background-color 0.2s;
  margin-bottom: 10px;
}

.sessionButton:hover {
  background-color: #1f81d1;
  transition: background-color 0.2s;
}

.alsoButton {
  cursor: pointer;
  font-weight: 500;
  transition: all 0.2s;
}

.alsoButton:hover {
  text-decoration: underline;
  transition: all 0.2s;
}

@media (min-width: 418px){
  .content {
      max-height: 500px;
  }
}

</style>