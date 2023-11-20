<script setup>
import TopBar from '../components/TopBar.vue';
import SideBar from "../components/SideBar.vue";
import axios from 'axios';
import mapboxgl from 'mapbox-gl';
import { ref, onMounted } from 'vue';

const generarNumeroAleatorio = () => Math.floor(Math.random() * 10000001);

const coordenadas = ref({ latitud: 0, longitud: 0 }); // Inicializamos con 0

const titulo = ref('');
const tipo = ref('');
const descripcion = ref('');
const equipamiento_necesario = ref('');
const ubicacionMessage = ref('');

const actualizarUbicacion = (lat, lng) => {
  coordenadas.value = { latitud: lat, longitud: lng };
  ubicacionMessage.value = `Ubicación actualizada:\nLatitud: ${lat}\nLongitud: ${lng}`;
};

const submitForm = async () => {
  if (!coordenadas.value.latitud || !coordenadas.value.longitud) {
    alert('Por favor, seleccione una ubicación en el mapa.');
    return;
  }

  const auxObject = {
    id_emergencia: generarNumeroAleatorio(),
    id_institucion: 2,
    tipo: tipo.value,
    latitud: coordenadas.value.latitud,
    longitud: coordenadas.value.longitud,
    equipamiento_necesario: equipamiento_necesario.value,
    titulo: titulo.value,
    descripcion: descripcion.value,
  };

  try {
    const apiUrl = import.meta.env.VITE_BASE_URL + "/emergencia";
    const response = await axios.post(apiUrl, auxObject);
    console.log('Respuesta del servidor:', response.data);
    alert('Emergencia registrada con éxito.');
  } catch (error) {
    console.error(auxObject);
    console.error('Error al enviar el formulario:', error);
  }
};




onMounted(() => {
  mapboxgl.accessToken = 'pk.eyJ1IjoiY3ZlcmFteiIsImEiOiJjbHA2NmM5NTEwYnk2MmxzaG92cmp5dXJ0In0.f9COSh1exBFKoqey1oNqOg';

  const map = new mapboxgl.Map({
    container: 'leafletMap',
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
        <h1>Crear Emergencia</h1>
        <p>A continuación rellene la siguiente información</p>
        <div class="form-container">
          <div class="card" style="margin-top: 20px;">
            <form @submit.prevent="submitForm">
              <label for="nombre-emergencia">Nombre de Emergencia:</label>
              <input type="text" id="nombre-emergencia" v-model="titulo" required>

              <label for="tipo-emergencia">Tipo de emergencia:</label>
              <input type="text" id="tipo-emergencia" v-model="tipo" required>

              <label for="descripcion">Descripción y requisitos:</label>
              <textarea id="descripcion" v-model="descripcion" placeholder="Detalle su emergencia e ingrese una lista de requisitos"></textarea>

              <label for="equipamiento">Equipamiento necesario:</label>
              <textarea id="equipamiento" v-model="equipamiento_necesario" placeholder="Detalle el equipamiento necesario"></textarea>

              <label for="ubicacion">Latitud:</label>
              <input type="number" v-model="coordenadas.latitud" placeholder="Latitud" step="0.000000000000001" min="-90" max="90" />

              <label for="ubicacion">Longitud:</label>
              <input type="number" v-model="coordenadas.longitud" placeholder="Longitud" step="0.000000000000001" min="-180" max="180" />

              <button type="submit">Registrar Emergencia</button>
            </form>
            <div>
              <h2>{{ ubicacionMessage }}</h2>
            </div>
            <div id="leafletMap" style="width: 550px; height: 400px;"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.view {
  display: flex;
  justify-content: center;
  padding-top: 110px;
}

.content {
  box-sizing: border-box;
  flex-direction: column;
  padding: 10px;
  width: 100%;
  max-width: 1200px;
}

.card {
  box-sizing: border-box;
  background-color: #ffffff;
  border-radius: 8px;
  margin-top: 20px;
  overflow: hidden;
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
}

#leafletMap {
  width: 100%;
  height: 400px;
}
</style>
