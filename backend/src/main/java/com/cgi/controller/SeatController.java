package com.cgi.controller;

import com.cgi.dtos.SeatPlanDto;
import com.cgi.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;
    @GetMapping(path = "/api/seats")
    public SeatPlanDto getSeatPlan(@RequestParam(name = "size") int size) {
        return seatService.getSeatsForMovie(size);
    }
}
