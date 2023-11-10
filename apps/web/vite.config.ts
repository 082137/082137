import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import mkcert from 'vite-plugin-mkcert';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), mkcert()],
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
    // proxy: {
    //   // '/api/dna': {
    //   //   target: 'http://10.160.39.3:9011',
    //   //   rewrite: (path) => path.replace(/^\/api/, ''),
    //   // },
    //   '/txm': 'http://dev.denall.com:82',
    //   '/api': 'http://dev.denall.com:82',
    // },
  },
});
