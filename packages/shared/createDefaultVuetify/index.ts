import 'vuetify/styles';
import { createVuetify, type VuetifyOptions } from 'vuetify';
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';
// import * as locales from 'vuetify/locale';
import { ko } from 'vuetify/locale';

export interface DefaultVuetifyOptions extends VuetifyOptions {}

export function createDefaultVuetify(options: DefaultVuetifyOptions = {}) {
  options.components = components;
  options.directives = directives;
  options.locale = {
    locale: 'ko',
    fallback: 'a',
    messages: {
      ko,
      a: {
        asdf: 'qwer',
      },
    },
  };
  return createVuetify(options);
}

/*
const vuetify = createVuetify({
  locale: {
    locale: 'zhHans',
    fallback: 'sv',
    messages: { zhHans, pl, sv },
  },
})
*/
