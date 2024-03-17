<template>
  <MovieFilters/>
  <MovieScroller/>
</template>

<script>
import MovieFilters from "@/components/MovieFilters.vue";
import MovieScroller from "@/components/MovieScroller.vue";

export default {
  name: "MovieDisplay",
  components: {MovieScroller, MovieFilters}
}
</script>

<style scoped>

</style>