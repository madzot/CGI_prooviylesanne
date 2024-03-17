<template>
  <v-layout>
    <v-main>
      <v-container>
        <v-card>
          <v-card-title>
            {{ this.movieName }}
          </v-card-title>
          <v-card-subtitle>
            {{ this.startTime }}
          </v-card-subtitle>
        </v-card>
      </v-container>
    </v-main>
  </v-layout>
</template>

<script>
export default {
  props: [
    'movieName',
    'startTime',
    'genre',
    'ageLimit',
  ],
  name: "MovieCard",
  movieName: null,
  startTime: null,
  genre: null,
  ageLimit: null,
  movieId: null,
}
</script>

<style scoped>

</style>