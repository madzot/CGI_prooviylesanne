import './assets/main.css'

import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import mitt from 'mitt'

import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/styles'
import {createVuetify} from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import * as labsComponents from 'vuetify/labs/components'
import axios from 'axios'

const vuetify = createVuetify({
    components,
    labsComponents,
    directives,
    ssr: true
})

axios.defaults.baseURL = 'http://localhost:8080/'
const token = localStorage.getItem('user-token')

if (token) {
    axios.defaults.headers.common['Authorization'] = "Bearer " + token
}

const app = createApp(App)
const emitter = mitt()

app.config.globalProperties.emitter = emitter

app.use(router).use(vuetify)

app.mount('#app')
