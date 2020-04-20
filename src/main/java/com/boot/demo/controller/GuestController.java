package com.boot.demo.controller;

import com.boot.demo.model.Guest;
import com.boot.demo.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    @Autowired
    private GuestRepository guestRepository;

    @GetMapping
    public List<Guest> getGuests(){
        return guestRepository.findAll();
    }

    @PostMapping
    public void addGuests(@RequestBody Guest guest){
        guestRepository.save(guest);
    }
    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Long id){
        guestRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public void updateGuest(@PathVariable ("id") Long id ,@RequestBody Guest guest){
        guest.setId(id);
        guestRepository.save(guest);

    }
}
