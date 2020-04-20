package com.boot.demo.controller;

import com.boot.demo.model.Trip;
import com.boot.demo.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    @Autowired
    private TripRepository tripRepository;

    @GetMapping
    public List<Trip> getTrip() {

        return tripRepository.findAll();
    }

    @PostMapping
    public void addTrip(@RequestBody Trip trip) {
        tripRepository.save(trip);
    }

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable("id") Long id) {
        tripRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateTrip(@PathVariable("id") Long id, @RequestBody Trip trip) {
        trip.setId(id);
        tripRepository.save(trip);
    }

}
