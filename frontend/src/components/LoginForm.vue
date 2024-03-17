<template>
  <v-layout>
    <v-main>
      <v-container class="d-flex h-screen">
        <v-row align="center">
          <v-col>
            <v-form>
              <v-card
                  class="mx-auto "
                  max-width="344"
                  title="Log in"
                  variant="tonal"
                  color="primary"
              >
                <v-container
                  :hidden="!this.status.localeCompare('')"
                >
                  <v-alert>
                    <v-alert-title>

                    </v-alert-title>
                  </v-alert>
                </v-container>
                <v-container>
                  <v-text-field
                      class="mb-4"
                      v-model="email"
                      color="primary"
                      label="Email"
                      variant="outlined"
                      placeholder="Enter your email"
                  ></v-text-field>

                  <v-text-field
                      v-model="password"
                      type="password"
                      color="primary"
                      label="Password"
                      placeholder="Enter your password"
                      variant="outlined"
                  ></v-text-field>
                  <v-card-text class="text-center">
                    <v-btn
                        size="small"
                        href="/signup"
                    >
                      Sign up now
                    </v-btn>
                  </v-card-text>

                  <v-divider></v-divider>

                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="success" type="submit">
                      Log In

                      <v-icon icon="mdi-chevron-right"></v-icon>
                    </v-btn>
                  </v-card-actions>
                </v-container>
              </v-card>
            </v-form>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-layout>
</template>

<script>
export default {
  name: "LoginForm",
  data: () => ({
    email: null,
    password: null,
    status: '',
  }),
}
</script>

<style scoped>

</style>