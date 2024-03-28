<template>
  <v-layout>
    <v-main>
      <v-container>
        <v-card
            color="#ededed"
            max-width="200"
        >
          <v-combobox
              clearable
              v-model="age"
              class="pt-4 px-2"
              density="compact"
              label="Age restriction"
              :items="['6+', '13+', '16+', '18+']"
          >
          </v-combobox>
          <v-divider></v-divider>
          <v-card-item>
            <v-card-subtitle>
              Movie genres:
            </v-card-subtitle>
            <v-checkbox
                density="compact"
                hide-details
                class="ma-0 pa-0"
                label="Thriller"
                v-model="genres"
                value="thriller"
            />
            <v-checkbox
                density="compact"
                hide-details
                label="Comedy"
                v-model="genres"
                value="comedy"
            />
            <v-checkbox
                density="compact"
                hide-details
                label="Action"
                v-model="genres"
                value="action"
            />
            <v-checkbox
                density="compact"
                hide-details
                label="Romantic"
                v-model="genres"
                value="romantic"
            />
            <v-checkbox
                density="compact"
                hide-details
                label="Documentary"
                v-model="genres"
                value="documentary"
            />
            <v-divider/>
            <v-card-subtitle

                class="mt-4"
            >
              Starting time
            </v-card-subtitle>
            <v-range-slider
                strict
                step="1"
                max="24"
                thumb-label
                color="blue"
            >
            </v-range-slider>
            <v-divider/>
            <v-card-subtitle class="mt-4">
              Language:
            </v-card-subtitle>
            <v-combobox
                density="compact"
                label="Language"
                chips
                multiple
                v-model="language"
                :items="['Estonian', 'English']"

            ></v-combobox>
          </v-card-item>
          <v-divider/>
          <v-btn onclick="">Search</v-btn>
        </v-card>
      </v-container>
    </v-main>
  </v-layout>
</template>

<script>
export default {
  name: "MovieFilters",
  data: () => ({
    genres: [],
    age: null,
    language: null,
    timeRange: [],
  }),
  methods: {
    emitFilters() {
      this.emitter.emit("ageRestriction", {msg: this.age})
      this.emitter.emit("genre", {msg: this.genres})
      this.emitter.emit("language", {msg: this.language})
      this.emitter.emit("startTime", {msg: this.timeRange})
    },
  },
  watch: {
    age(n, o) {
      this.emitFilters()
    },
    language() {
      this.emitFilters()
    },
    timeRange() {
      this.emitFilters()
    },
    genres() {
      this.emitFilters()
    }
  }
}
</script>

<style scoped>

</style>