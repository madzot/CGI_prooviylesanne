package com.cgi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SeatPlanDto {
    private List<List<List<Integer>>> seatPlan;
    private List<List<Integer>> takenSeats;
    private List<List<Integer>> recommendedSeats;
}
