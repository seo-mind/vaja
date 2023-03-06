import { createWebHistory, createRouter } from "vue-router";
import LoginComp from './components/LoginComp.vue';
import SignupComp from './components/SignupComp';

const routes = [
  {
    path: "/",
    component:  LoginComp //import해온 컴포넌트,
  },
  {
    path: "/signup",
    component:  SignupComp //import해온 컴포넌트,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router; 