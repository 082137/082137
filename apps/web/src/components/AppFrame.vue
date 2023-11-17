<script setup lang="ts">
import { computedEager } from '@vueuse/core';
import { useRoute } from 'vue-router';

const route = useRoute();
console.log('route', route);
const src = computedEager(() => {
  const { path, fullPath } = route;
  if (path.startsWith('/tv')) {
    return 'https://denall.com' + fullPath.replace('/tv', '');
  } else if (path.startsWith('/mall')) {
    return 'https://mall.denall.com/main/main.do' + fullPath.replace('/mall', '');
  } //https://mall.denall.com/main/main.do?method=main&subPjtType=DSC
  return '';
});
</script>

<template>
  <iframe
    :class="$style.iframe"
    :src="src"
  >
    sadfslkadjflsakjdf
  </iframe>
</template>

<style lang="scss" module>
.iframe {
  width: 100%;
  height: 100%;
  border: 0;
}
</style>
