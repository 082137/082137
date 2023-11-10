import { createRouter, createWebHistory, type RouterHistory, type RouterOptions } from 'vue-router';

const { BASE_URL } = import.meta.env;

export interface DefaultRouterOptions extends Omit<RouterOptions, 'history'> {
  history?: RouterHistory;
}

export function createDefaultRouter(
  options: DefaultRouterOptions = {
    routes: [],
  }
) {
  return createRouter({
    history: createWebHistory(BASE_URL),
    scrollBehavior: (to, _from, savedPosition) => {
      const behavior = 'smooth';
      if (to.hash) return { behavior, el: to.hash };
      if (savedPosition) return savedPosition;
      return { behavior, top: 0 };
    },
    ...options,
  });
}
