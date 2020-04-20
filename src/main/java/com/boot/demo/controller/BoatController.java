package com.boot.demo.controller;

import com.boot.demo.model.Boat;
import com.boot.demo.repositories.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/boats")
public class BoatController {
    @Autowired
    private BoatRepository boatRepository;

    @GetMapping
    public List<Boat> getBoats() {
        return boatRepository.findAll();
    }
//    @GetMapping("/search")
//    public Boat getBoat(@RequestParam String boatNumber){
//        return boatRepository.findOneByBoatNumber(boatNumber);
//    }

    @PostMapping
    public String addBoat(@RequestBody Boat boat) {
        Boat availableBoat = boatRepository.findOneByBoatNumber(boat.getBoatNumber());
        if (availableBoat != null) {
            return "The boat number " + boat.getBoatNumber() + "is already exist . try to set number again.";

        }
        boatRepository.save(boat);
        return "The Boat is created.";

        }

    @DeleteMapping("/{id}")
    public void deleteBoat(@PathVariable Long id) {
        boatRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateBoat(@PathVariable("id") Long id, @RequestBody Boat boat){
        boat.setId(id);
        boatRepository.save(boat);

}
    

}
