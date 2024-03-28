<template>
  <v-layout>
    <v-main>
      <v-container>
        <v-btn @click="this.getMovies()"

        >
          Search
        </v-btn>
      </v-container>
      <v-container
          class="d-flex justify-center"
          v-for="movie in movies" :key="movie.movieId"
      >
        <MovieCard
            :movieName="movie.title"
            :genre="movie.genre"
            :ageLimit="movie.ageRestriction"
            :language="movie.language"
        />

      </v-container>
    </v-main>
  </v-layout>
</template>

<script>
import MovieCard from "@/components/MovieCard.vue";
import axios from "axios";

export default {
  name: "MovieScroller",
  components: {MovieCard},
  data: () => ({
    movies: [],
  }),
  methods: {
    async getMovies() {
      this.movies = []
      const headers = {
        'Access-Control-Allow-Origin': '*',
        "Content-Type": "application/json"
      }
      const data = [
        {
          "columnName": "genre",
          "columnValue": this.genres,
        },
        {
          "columnName": "language",
          "columnValue": this.language,
        },
        {
          "columnName": "age_restriction",
          "columnValue": this.ageRestriction,
        },
        {
          "columnName": "startTime",
          "columnValue": this.startTime,
        },
      ]
      const response = await axios.post("http://localhost:8080/api/movies", data, {headers: headers});
      console.log(response)
      for (const element of response.data) {
        const array = {
          title: element.title,
          genre: element.genre,
          ageRestriction: element.ageRestriction,
          language: element.language,
        }
        console.log(array)
        this.movies.push(array);
      }
    },
    loadFilters() {
      this.emitter.on("genres", (data) => {
        this.genres = data.msg.id;
      });
      this.emitter.on("ageRestriction", (data) => {
        this.ageRestriction = data.msg.id;
      });
      this.emitter.on("startTime", (data) => {
        this.startTime = data.msg.id;
      });
      this.emitter.on("language", (data) => {
        this.language = data.msg.id;
      });

    }
  },
  mounted() {
    this.getMovies();
  }
}
</script>

<style scoped>

</style>