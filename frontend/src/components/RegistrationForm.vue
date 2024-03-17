<template>
  <v-layout>
    <v-main>
      <v-container class="d-flex h-screen">
        <v-row align="center">
          <v-col>
            <v-card
                class="mx-auto"
                max-width="350"
                title="Sign Up">

              <v-container
                  :hidden="!this.status.localeCompare('')">

                <v-alert
                    variant="tonal"
                    type="error"
                >
                  <v-alert-title>
                    {{ this.status }}
                  </v-alert-title>
                </v-alert>

              </v-container>

              <v-form validate-on="submit lazy" @submit.prevent="submit">
                <v-container>

                  <v-text-field
                      class="mb-4"
                      v-model="first"
                      color="primary"
                      label="First name"
                      variant="outlined"
                      :rules="[() => !!first || 'This field is required']"
                  ></v-text-field>

                  <v-text-field
                      v-model="last"
                      color="primary"
                      label="Last name"
                      variant="outlined"
                      class="mb-4"
                      :rules="[() => !!last || 'This field is required']"
                  ></v-text-field>

                  <v-text-field
                      v-model="email"
                      color="primary"
                      label="Email"
                      variant="outlined"
                      :rules="[v=> !!v || 'This field is required', v => v.match('.+@\\w+\\.\\w+') || 'Invalid email address']"
                      class="mb-4"
                      validate-on="input"
                  ></v-text-field>

                  <v-text-field
                      v-model="password"
                      type="password"
                      color="primary"
                      label="Password"
                      placeholder="Enter your password"
                      variant="outlined"
                      :rules="[v => !!v || 'This field is required']"
                      class="mb-4"
                      validate-on="input"
                  ></v-text-field>

                  <v-text-field
                      v-model="passwordConfirm"
                      :disabled="!this.passwordIsValid"
                      type="password"
                      color="primary"
                      label="Verify password"
                      placeholder="Enter password again"
                      variant="outlined"
                      :rules="[v => v === this.password || 'Passwords do not match']"
                      class="mb-4"
                      validate-on="input"
                  ></v-text-field>

                  <v-checkbox
                      v-model="terms"
                      color="secondary"
                      label="I agree to site terms and conditions"
                      :rules="[ v => v === true|| 'Must accept terms.']"
                  ></v-checkbox>
                </v-container>
                <v-divider></v-divider>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn
                      :disabled="!this.formIsValid"
                      type="submit"
                      color="success">
                    Sign Up
                    <v-icon icon="mdi-chevron-right"></v-icon>
                  </v-btn>
                </v-card-actions>
              </v-form>
            </v-card>
          </v-col>
        </v-row>
      </v-container>

    </v-main>
  </v-layout>
</template>

<script>
import axios from "axios";
import router from "@/router/index.js";
export default {
  name: "RegistrationForm",
  data: () => ({
    first: '',
    last: '',
    email: '',
    status: '',
    password: '',
    passwordConfirm: '',
    terms: false,
  }),
  computed: {
    formIsValid() {
      return this.terms === true
          && this.first.localeCompare('')
          && this.last.localeCompare('')
          && this.email.localeCompare('')
          && this.password.localeCompare('')
    },
    passwordIsValid() {
      return this.password.localeCompare('')
    }
  },
  methods: {
    submit: async function (event) {
      const data = {
        "firstName": this.first,
        "lastName": this.last,
        "email": this.email,
        "password": this.password,
        "passwordConfirm": this.passwordConfirm,
      }
      const headers = {
        'Access-Control-Allow-Origin': '*',
        "Content-Type": "application/json"
      }
      const response = await axios.post("api/account", data, {headers: headers})
      try {
        if (response.status === 200) {
          await router.push('/login')
        }
      } catch (Exception) {
        this.status = "An error occurred creating your account"
      }

    }
  }
}
</script>

<style scoped>

</style>