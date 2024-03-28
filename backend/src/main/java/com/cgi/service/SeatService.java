package com.cgi.service;

import com.cgi.dtos.SeatPlanDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class SeatService {
    private final Random random = new Random();
    private List<List<List<Integer>>> seatPlan = new ArrayList<>();
    private List<List<Integer>> takenSeats = new ArrayList<>();
    private void generateSeatPlan(int size) {
        if (size <= 0) throw new IllegalArgumentException();
        seatPlan.clear();
        takenSeats.clear();
        int borderPoint = size / 2;
        for (int y = borderPoint; y > -borderPoint; y--) {
            List<List<Integer>> row = new ArrayList<>();
            for (int x = -borderPoint; x < borderPoint; x++) {
                List<Integer> seat = List.of(x, y);
                row.add(seat);
            }
            seatPlan.add(row);
        }
    }
    private void generateRandomlyTakenSeats() {
        this.takenSeats.clear();
        List<List<Integer>> newTakenSeats = new ArrayList<>();
        int boundY = seatPlan.get(0).get(0).get(1);
        int boundX = -seatPlan.get(0).get(0).get(0);
        double totalSeats = Math.pow(seatPlan.size(), 2);
        int amountTaken = random.nextInt((int) totalSeats);
        for (int i = 0; i < amountTaken; i++) {
            int randomY = random.nextInt(-boundY, boundY);
            int randomX = random.nextInt(-boundX, boundX);
            List<Integer> seat = List.of(randomX, randomY);
            boolean seatTaken = false;
            for (List<Integer> takenSeat: newTakenSeats) {
                seatTaken = takenSeat == seat;
            }
            if (!seatTaken) newTakenSeats.add(seat);
        }
        this.takenSeats = newTakenSeats;
    }
    private List<List<Integer>> findBestSeat() {
        Map<Float, List<Integer>> distances = new TreeMap<>();
        for (List<List<Integer>> row: seatPlan) {
            for (List<Integer> seat: row) {
                int x = seat.get(0);
                int y = seat.get(1);
                double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                distances.put((float) distance, seat);
            }
        }
        return new ArrayList<>(distances.values());
    }
    public SeatPlanDto getSeatsForMovie(int size) {
        generateSeatPlan(size);
        generateRandomlyTakenSeats();
        return new SeatPlanDto(seatPlan, takenSeats, findBestSeat());
    }
}
