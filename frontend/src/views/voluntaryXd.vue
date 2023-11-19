<script setup>

import TopBar from '../components/TopBar.vue';
import SideBar from "../components/SideBar.vue";
import axios from 'axios';
</script>

<script>

function generarNumeroAleatorio() {
  return Math.floor(Math.random() * 10000001);
}

export default {
  data() {
    return {
      nombre: '',
      edad: '',
      equipamiento: '',
      estado_salud: '',
      disponibilidad: '',
      email_voluntario:'',
      password_voluntario: '',
      latitud: '',
      longitud: '',
    };
  },
  methods: {
    async submitForm() {
      const auxObject = {
          id_emergencia: generarNumeroAleatorio(),
          id_institucion: 2,
          tipo: this.tipo,
          ubicacion: this.ubicacion,
          equipamiento_necesario: this.equipamiento_necesario,
          titulo: this.titulo,
          descripcion: this.descripcion,
        };
        const apiUrl = import.meta.env.VITE_BASE_URL + "/emergencia";
      try {
        const response = await axios.post(apiUrl, auxObject);
        console.log('Respuesta del servidor:', response.data);
      } catch (error) {
        console.error(auxObject);
        console.error('Error al enviar el formulario:', error);
      }
    }
  }
}
</script>


<template>
  <div>
    <TopBar />
    <SideBar />
    <div class="view">
      <div class="content">
        <h1>Agregar voluntario</h1>
        <p>A continuación rellene la siguiente información</p>
        <div class="form-container">

          <div class="card" style="margin-top: 20px;">
            <form @submit.prevent="submitForm">
              <label for="nombre-emergencia">Nombre voluntario:</label>
              <input type="text" id="nombre-emergencia" v-model="nombre" required>

              <label for="tipo-emergencia">Edad:</label>
              <input type="number" min="0" id="tipo-emergencia" v-model="edad" required>

              <label for="equipamiento">Equipamiento:</label>
              <input type="text" id="equipamiento" v-model="equipamiento" required>


              <label for="estado">Estado salud:</label>
              <input id="estado" v-model="estado_salud"/>

              <label for="disponibilidad">Disponibilidad:</label>
              <input id="disponibilidad" v-model="disponibilidad"/>

              <label for="email">Email:</label>
              <input id="email" v-model="email_voluntario"/>

              <label for="password">Password:</label>
              <input id="password" v-model="password_voluntario"/>

              <label for="latitud">Latitud:</label>
              <input id="latitud" v-model="latitud"/>

              <label for="longitud">Longitud:</label>
              <input id="latitud" v-model="longitud" class=""/>

              

              <button type="submit">Registrar Emergencia</button>
            </form>
            <iframe src="https://maps.google.com/maps?q=santiago&amp;t=&amp;z=13&amp;ie=UTF8&amp;iwloc=&amp;output=embed" frameborder="0" scrolling="no" style="width: 550px; height: 400px;"></iframe> 
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.view {
  box-sizing: border-box;
  display: flex;
  justify-content: center;
  margin-left: 70px;
  padding-top: 110px;
}

.content {
  display: flex;
  justify-content: center;
  box-sizing: border-box;
  flex-direction: column;
  padding: 10px;
  width: 100%;
  margin: auto !important;
  max-width: 1200px;
}

.input {
  width: 100%;
}

.card {
  display: flex;
  margin: auto;
  flex-direction: column;
  max-width: 800px;
  box-sizing: border-box;
  background-color: #ffffff;
  width: 100%;
  padding: 20px;
  border-radius: 8px;
}

h1 {
  font-weight: 700;
  font-size: 24px;
  color: #0288D1;
}

h2 {
  font-weight: 500;
  font-size: 20px;
}

.form-container {
  margin-top: 20px;
}

form {
  display: flex;
  flex-direction: column;
  max-width: 300px;
}

input,
textarea,
select,
button {
  margin-bottom: 10px;
}</style>