import { initFederation } from '@softarc/native-federation';
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

// (async () => {
//   await initFederation({});
// })();

createApp(App).use(core).mount('#app');
