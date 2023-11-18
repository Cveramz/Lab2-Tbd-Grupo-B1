<script setup>
import TopBar from '../components/TopBar.vue';
import SideBar from "../components/SideBar.vue"
</script>

<script>
import axios from 'axios';

function generarNumeroAleatorio() {
  return Math.floor(Math.random() * 10000001);
}

export default {
  data() {
    return {
      descripcion: "",
      username: null,
      id: JSON.parse(localStorage.getItem("idUsuario")),
      date: null,
      tasks: [],
    }
  },
  methods: {
    getLogin(){
      this.username = JSON.parse(localStorage.getItem("login"))
      this.id = JSON.parse(localStorage.getItem("idUsuario"))
    },
    
    async crearTarea(){
      // Enviar datos a backend
      const auxObject = {
        id_tarea: generarNumeroAleatorio(),
        id_usuario: this.id,
        titulo: this.descripcion,
        descripcion: this.descripcion,
        fecha_vencimiento: this.date,
        estado: "pendiente",
      };

      try {
        const apiUrl = import.meta.env.VITE_BASE_URL + "/tarea";
        const respuesta = await axios.post(apiUrl, auxObject);
        console.log(respuesta.data); 
        alert("La tarea se ha registrado correctamente");
      }catch(error){
        alert("Hay problemas para registrar la tarea");
      }
    },
    async getTareas(){

      try {
        const res = await axios(import.meta.env.VITE_BASE_URL + `/tarea/${this.id}`)
        this.tasks = res.data;
      } catch (error){
        alert("error en conectar al servidor")
      }
    },
  },
  mounted() {
    this.getLogin();
    this.getTareas();
  }
}
</script>


<template>
  <TopBar/>
  <SideBar />
  <div class="view">
    <div class="content">
      <h1>Emergencia {nombreEmergencia}</h1>
      <p>A continuación, se presenta los detalles de la emergencia
      </p>
      <div class="card" style="margin-top: 20px;">
        <div> 
          <h2 style="margin-bottom: 10px;"></h2>
          <div v-if="this.tasks.length === 0">
            <div>no hay datos de la emergencia</div>
          </div>
          <div v-else>
            <table>
            <tr>
              <th>Estado actual</th>
              <th>voluntarios registrados</th>
              <th>detalles</th>
            </tr>
            <tr v-for="task in tasks">
              <td>{{ task.titulo }}</td>
              <td>{{ task.fecha_vencimiento }}</td>
              <td>{{ task.estado }}</td>
            </tr>
            </table>
          </div>
         
        </div>
        
      </div>
    </div>
  </div>
</template>

<style>

h1 {
  font-weight: 700;
  font-size: 24px;
  color: #0288D1;
}
h2 {
  font-weight: 500;
  font-size: 20px;
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
.select {
  background-color: #fafafa;
  height: 30px;
  font-size: 16px;
  width: 100%;
  max-width: 400px;
  border-radius: 6px;
}
.description {
  box-sizing: border-box;
  background-color: #fafafa;
  height: 30px;
  font-size: 16px;
  width: 100%;
  font-family: roboto;
  padding: 10px;
  border-radius: 6px 0px 0px 6px;
  resize: vertical;
  max-width: 100%;
  min-height: 50px;
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
  width: 100%;
  transition: background-color 0.2s;
  margin-bottom: 10px;
}
</style>
