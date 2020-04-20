package com.boot.demo.controller;

import com.boot.demo.model.Boat;
import com.boot.demo.model.Reservation;
import com.boot.demo.repositories.BoatRepository;
import com.boot.demo.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")

public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
   @Autowired
   private BoatRepository boatRepository;
    @GetMapping
    public List<Reservation> getReservation(){
       return reservationRepository.findAll();
    }



    @GetMapping("/search/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationRepository.findById(id).get();
    }

    @PostMapping
   public void addReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable("id") Long id){
        reservationRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public void updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation){
        reservation.setId(id);
        reservationRepository.save(reservation);
    }

}
