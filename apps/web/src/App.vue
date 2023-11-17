<script setup lang="ts">
import AppButton from 'remote/AppButton';
// import { defineAsyncComponent } from 'vue';

// const cccc = defineAsyncComponent(() => import('remote-app/Button.vue'));
// console.log('cccc', cccc);
</script>

<template>
  <VApp>
    <VAppBar />
    <VNavigationDrawer>
      <VExpansionPanels>
        <VExpansionPanel title="덴올">
          <AppButton />
          <VBtn
            class="w-100"
            to="/tv/main?"
          >
            https://denall.com
          </VBtn>
        </VExpansionPanel>
        <VExpansionPanel title="덴올몰">
          <VBtn
            class="w-100"
            to="/mall?method=main"
          >
            덴올몰
          </VBtn>
          <VBtn
            class="w-100"
            to="/mall?method=main&subPjtType=DSC"
          >
            덴올몰 > 라이프
          </VBtn>
        </VExpansionPanel>
      </VExpansionPanels>
    </VNavigationDrawer>
    <VMain>
      <VContainer
        tag="section"
        :class="$style.container"
      >
        <RouterView />
      </VContainer>
    </VMain>
  </VApp>
</template>

<style lang="scss" module>
.container {
  width: 100%;
  height: 100%;
  padding: 0;
  margin: 0;
  overflow: hidden;
}
</style>
