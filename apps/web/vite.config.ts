import { defineConfig } from 'vite';
import { federation } from '@module-federation/vite';
import { createEsBuildAdapter } from '@softarc/native-federation-esbuild';
import vue from '@vitejs/plugin-vue';
import mkcert from 'vite-plugin-mkcert';

// https://vitejs.dev/config/
export default defineConfig(async ({ command }) => ({
  plugins: [
    vue(),
    mkcert(),
    // await federation({
    //   options: {
    //     workspaceRoot: __dirname,
    //     outputPath: 'dist',
    //     tsConfig: 'tsconfig.json',
    //     federationConfig: 'module-federation/federation.config.cjs',
    //     verbose: false,
    //     dev: command === 'dev',
    //   },
    //   adapter: createEsBuildAdapter({ plugins: [] }),
    // }),
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
}));
