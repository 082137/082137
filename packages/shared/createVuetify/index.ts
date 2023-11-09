import 'vuetify/styles';
import { createVuetify } from 'vuetify';
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';

function create() {
  return createVuetify({
    components,
    directives,
  });
}

export { create as createVuetify };
