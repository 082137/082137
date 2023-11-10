import { createCore } from '@082137/core';
import { createApp } from 'vue';
// import './style.css';
import App from './App.vue';

const core = createCore({
  routerOptions: {
    routes: [],
  },
});

createApp(App).use(core).mount('#app');
