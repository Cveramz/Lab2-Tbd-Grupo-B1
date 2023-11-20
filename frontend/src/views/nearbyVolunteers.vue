<template>
  <div>
    <TopBar />
    <SideBar />

    <div class="view">
      <div class="content">
        <h1>Voluntarios Cercanos</h1>
        <p>Ingrese un id de emergencia y la cantidad de voluntarios a filtrar</p>

        <div class="card" style="margin-top: 20px;">
          <form @submit.prevent="submitForm">
            <!-- Agregué una clase 'input-field' para dar estilo al formulario -->
            <div class="input-field">
              <label for="id-emergencia">Id Emergencia:</label>
              <input type="text" id="id-emergencia" v-model="id_emergencia" required>
            </div>

            <div class="input-field">
              <label for="cantidad-voluntarios">Cantidad de voluntarios:</label>
              <input type="number" id="cantidad-voluntarios" v-model="cantidad_voluntarios" required>
            </div>

            <button type="submit">Buscar Voluntarios</button>
          </form>
        </div>

        <div v-if="voluntariosCercanos.length > 0">
          <h2>Voluntarios Cercanos:</h2>
          <!-- Agregué una clase 'table' para dar estilo a la tabla -->
          <table class="table">
            <thead>
              <tr>
                <th>Nombre</th>
                <th>Distancia (metros)</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="voluntario in voluntariosCercanos" :key="voluntario.id_voluntario">
                <td>{{ voluntario.nombre_voluntario }}</td>
                <td>{{ voluntario.distancia_en_metros }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import TopBar from '../components/TopBar.vue';
import SideBar from "../components/SideBar.vue";
import axios from 'axios';

const id_emergencia = ref('');
const cantidad_voluntarios = ref('');
const voluntariosCercanos = ref([]);

const submitForm = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/Voluntario/Nvoluntario/?N=${cantidad_voluntarios.value}&id_emergencia=${id_emergencia.value}`);

    voluntariosCercanos.value = response.data;
  } catch (error) {
    console.error('Error al obtener voluntarios cercanos:', error);
  }
};
</script>

<style>
/* Estilos de la tabla */
.table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

.table th, .table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

.table th {
  background-color: #f2f2f2;
}
/* Estilos del formulario */
.input-field {
  margin-bottom: 10px;
}

input {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
}
</style>
