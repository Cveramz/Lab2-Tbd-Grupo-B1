import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../views/homeView.vue'),
      alias: '/inicio',
    },
    {
      path: '/allEmergencies',
      name: 'todasLasEmergencias',
      component: () => import('../views/allEmergenciesView.vue'),
    },
    {
      path: '/tasks',
      name: 'tareas',
      component: () => import('../views/taskView.vue'),
    },
    {
      path: '/history',
      name: 'historial',
      component: () => import('../views/historialView.vue'),
    },
    {
      path: '/registerEmergency',
      name: 'registrarEmergencia',
      component: () => import('../views/registerEmergency.vue'),
    },
    {
      path: '/addVoluntary',
      name: 'agregarVoluntario',
      component: () => import('../views/addVoluntary.vue'),
    },
    {
      path: '/nearbyVolunteers',
      name: 'voluntariosCercanos',
      component: () => import('../views/nearbyVolunteers.vue'),
    }
  ],
});

export default router;
