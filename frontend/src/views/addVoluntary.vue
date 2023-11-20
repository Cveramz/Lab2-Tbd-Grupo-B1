<script setup>
import TopBar from '../components/TopBar.vue';
import SideBar from "../components/SideBar.vue";
import axios from 'axios';
import mapboxgl from 'mapbox-gl';
import { ref, onMounted } from 'vue';

const generarNumeroAleatorio = () => Math.floor(Math.random() * 10000001);

const nombre = ref('');
const edad = ref(0); // Asegúrate de que sea un número en lugar de una cadena
const equipamiento = ref('');
const estado_salud = ref('');
const disponibilidad = ref(null); // Puedes ajustar el valor por defecto según tus necesidades
const email_voluntario = ref('');
const password_voluntario = ref('');
const latitud = ref(0); // Asegúrate de que sea un número en lugar de una cadena
const longitud = ref(0); // Asegúrate de que sea un número en lugar de una cadena

const submitForm = async () => {
  const auxObject = {
    id_voluntario: generarNumeroAleatorio(),
    nombre_voluntario: nombre.value,
    edad: edad.value,
    equipamiento: equipamiento.value,
    estado_salud: estado_salud.value === 'capacitado',
    disponibilidad: disponibilidad.value === 'disponible',
    email_voluntario: email_voluntario.value,
    password_voluntario: password_voluntario.value,
    latitud: latitud.value,
    longitud: longitud.value,
  };

  const apiUrl = import.meta.env.VITE_BASE_URL + "/voluntario"; // Actualiza el endpoint según tu API
  try {
    const response = await axios.post(apiUrl, auxObject);
    console.log('Respuesta del servidor:', response.data);
    alert('Voluntario registrado con éxito.');
  } catch (error) {
    console.error(auxObject);
    console.error('Error al enviar el formulario:', error);
  }
};

const actualizarUbicacion = (lat, lng) => {
  latitud.value = lat;
  longitud.value = lng;
  alert(`Ubicación actualizada:\nLatitud: ${lat}\nLongitud: ${lng}`);
};

onMounted(() => {
  mapboxgl.accessToken = 'pk.eyJ1IjoiY3ZlcmFteiIsImEiOiJjbHA2NmM5NTEwYnk2MmxzaG92cmp5dXJ0In0.f9COSh1exBFKoqey1oNqOg';

  const map = new mapboxgl.Map({
    container: 'mapContainer',
    style: 'mapbox://styles/mapbox/satellite-streets-v11',
    center: [-70.6692655, -33.4488897],
    zoom: 13,
  });

  map.on('click', (event) => {
    const { lng, lat } = event.lngLat;
    actualizarUbicacion(lat, lng);
  });
});
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
              <select id="estado" v-model="estado_salud">
        <option value="capacitado">Capacitado</option>
        <option value="incapacitado">Incapacitado</option>
      </select>

              <label for="disponibilidad">Disponibilidad:</label>
              <select id="disponibilidad" v-model="disponibilidad">
        <option value="disponible">Disponible</option>
        <option value="no_disponible">No Disponible</option>
      </select>

              <label for="email">Email:</label>
              <input id="email" v-model="email_voluntario"/>

              <label for="password">Password:</label>
              <input id="password" v-model="password_voluntario"/>

              <label for="latitud">Latitud:</label>
              <input id="latitud" v-model="latitud"/>

              <label for="longitud">Longitud:</label>
              <input id="longitud" v-model="longitud" class=""/>

              <!-- Eliminado el iframe de Google Maps, ya que usamos Mapbox GL JS -->
              <div id="mapContainer" style="width: 550px; height: 400px;"></div>

              <button type="submit">Registrar Voluntario</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<style scoped>

#mapContainer {
  width: 100%;
  height: 400px;
}
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