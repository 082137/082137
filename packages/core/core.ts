import { createVuetify } from '@082137/shared';
import { type App } from 'vue';

function create() {
  const vuetify = createVuetify();

  return {
    vuetify,
    install(app: App) {
      app.use(vuetify);
    },
  };
}

export { create as createCore };
