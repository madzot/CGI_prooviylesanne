<template>
  <v-layout>
    <v-main>
      <v-container
          class="d-flex justify-center"
          v-for="movie in movies" :key="movie.movieId"
      >
        <MovieCard
            :movieName="movie.name"
            :movieGenre="movie.genre"
            :movieStartTime="movie.startTime"
            :movieAgeLimit="movie.ageLimit"
        />

      </v-container>
    </v-main>
  </v-layout>
</template>

<script>
import MovieCard from "@/components/MovieCard.vue";

export default {
  name: "MovieScroller",
  components: {MovieCard},
  data: () => ({
    movies: [],
  }),
  methods: {
    async getMovies() {

    }
  }
}
</script>

<style scoped>

</style>