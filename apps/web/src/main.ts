import { createCore } from '@082137/core';
import { createApp } from 'vue';

import App from '@/App.vue';

const core = createCore({
  routerOptions: {
    routes: [
      {
        path: '/tv',
        children: [{ path: ':pathMatch(.*)*', component: () => import('@/components/AppFrame.vue') }],
      },
      {
        path: '/mall',
        children: [{ path: ':pathMatch(.*)*', component: () => import('@/components/AppFrame.vue') }],
      },
    ],
  },
  vuetifyOptions: {
    locale: {
      locale: 'ko',
    },
  },
});

createApp(App).use(core).mount('#app');
