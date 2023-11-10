import { createCore } from '@082137/core';
import { createApp } from 'vue';
// import './style.css';
import App from './App.vue';

const core = createCore({
  routerOptions: {
    routes: [],
  },
  vuetifyOptions: {
    locale: {
      locale: 'ko',
    },
  },
});

createApp(App).use(core).mount('#app');
