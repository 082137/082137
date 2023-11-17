import { defineConfig } from 'vite';
import federation from '@originjs/vite-plugin-federation';
import vue from '@vitejs/plugin-vue';
import topLevelAwait from 'vite-plugin-top-level-await';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    federation({
      name: 'remote',
      filename: 'remote-entry.js',
      // Modules to expose
      exposes: {
        './AppButton': './src/components/AppButton.vue',
      },
      shared: ['vue'],
    }),
    topLevelAwait(),
  ],
});
