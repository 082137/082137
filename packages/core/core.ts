import {
  createDefaultAxios,
  createDefaultRouter,
  createDefaultVuetify,
  type DefaultAxiosOptions,
  type DefaultRouterOptions,
  type DefaultVuetifyOptions,
} from '@082137/shared';
import { type App } from 'vue';

export interface CoreOptions {
  axiosOptions?: DefaultAxiosOptions;
  routerOptions?: DefaultRouterOptions;
  vuetifyOptions?: DefaultVuetifyOptions;
}

export function createCore(options: CoreOptions = {}) {
  const axios = createDefaultAxios(options.axiosOptions);
  const router = createDefaultRouter(options.routerOptions);
  const vuetify = createDefaultVuetify(options.vuetifyOptions);
  return {
    axios,
    router,
    vuetify,
    install(app: App) {
      app.use(router).use(vuetify);
    },
  };
}
