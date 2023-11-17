import {
  createDefaultAxios,
  createDefaultRouter,
  createDefaultVuetify,
  type DefaultAxiosOptions,
  type DefaultRouterOptions,
  type DefaultVuetifyOptions,
} from '@082137/shared';
import { type App, warn } from 'vue';

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
      console.log('warn', warn);
      app.use(router).use(vuetify);
      app.config.globalProperties.$t = function (key, ...args) {
        console.log('this', this, 'key', key);
        return;
      };
      // Object.defineProperty(app.config.globalProperties, '$t', {
      //   value: function (key: string) {
      //     console.log('this', this);
      //     return this.$vuetify.locale.t(`$vuetify.${key}`);
      //   },
      // });
    },
  };
}
