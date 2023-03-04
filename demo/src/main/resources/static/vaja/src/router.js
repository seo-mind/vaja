import { createWebHistory, createRouter } from "vue-router";
import HelloWorld from './components/HelloWorld.vue';

const routes = [
  {
    path: "/경로",
    component:  HelloWorld //import해온 컴포넌트,
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router; 