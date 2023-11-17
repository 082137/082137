import { defineConfig } from 'vite';
import federation from '@originjs/vite-plugin-federation';
import vue from '@vitejs/plugin-vue';
import mkcert from 'vite-plugin-mkcert';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    mkcert(),
    federation({
      name: 'host-app',
      remotes: {
        remote: 'http://localhost:4173/assets/remote-entry.js',
      },
      shared: ['vue', 'pinia'],
    }),
  ],
  build: {
    rollupOptions: {
      output: {
        manualChunks: {
          vuetify: ['vuetify'],
        },
      },
    },
  },
  css: {
    devSourcemap: true,
  },
  resolve: {
    alias: [{ find: '@', replacement: '/src' }],
  },
  server: {
    https: true,
  },
});
