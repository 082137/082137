import 'vuetify/styles';
import { createVuetify, type VuetifyOptions } from 'vuetify';
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';

export interface DefaultVuetifyOptions extends VuetifyOptions {}

export function createDefaultVuetify(options: DefaultVuetifyOptions = {}) {
  options.components = components;
  options.directives = directives;
  return createVuetify(options);
}
