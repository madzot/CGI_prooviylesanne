<template>
  <v-layout>
    <v-main>
      <v-row>
        <v-col>
            <v-card
                v-for="item in seatPlan" :key="item.id"
            >
              {{ item }}
            </v-card>

        </v-col>
      </v-row>
      <v-row>
        <v-card>
          Recommended seat for 1 person is : {{ this.recommendedSeats[0] }}
        </v-card>
        <v-card>
          Taken seats are: {{ this.takenSeats }}
        </v-card>
      </v-row>
    </v-main>
  </v-layout>
</template>

<script>
import axios from "axios";

export default {
  name: "SeatPlan",
  data: () => ({
    seatPlan: [],
    takenSeats: [],
    recommendedSeats: [],
    size: null,
  }),
  methods: {
    async getSeatPlan() {
      const headers = {
        'Access-Control-Allow-Origin': '*',
        "Content-Type": "application/json"
      }
      const params = {
        size: 10,
      }
      const response = await axios.get("http://localhost:8080/api/seats", {headers: headers, params: params})
      console.log(response);
      this.seatPlan = response.data.seatPlan;
      this.takenSeats = response.data.takenSeats;
      this.recommendedSeats = response.data.recommendedSeats;
      this.size = response.data.seatPlan.size;
    }
  },
  mounted() {
    this.getSeatPlan();
  },
}
</script>

<style scoped>

</style>