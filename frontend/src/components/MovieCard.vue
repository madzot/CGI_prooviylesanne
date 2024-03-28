<template>
  <v-layout>
    <v-main>
      <v-container>
        <v-card @click.once="this.$router.push('/seats')">
          <v-card-title>
            {{ this.movieName }}
          </v-card-title>
          <v-card-subtitle>
            {{ this.genre }}
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
    'language',
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