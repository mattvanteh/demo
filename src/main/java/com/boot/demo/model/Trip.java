package com.boot.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Entity
public class Trip {

    @Id
    @GeneratedValue
    private Long id;
    private Integer totalPrice;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDate startTrip;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDate endTrip;



    @ManyToOne
    private Boat boat;
    @ManyToOne
    private Guest guest;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getStartTrip() {
        return startTrip;
    }

    public void setStartTrip(LocalDate startTrip) {
        this.startTrip = startTrip;
    }

    public LocalDate getEndTrip() {
        return endTrip;
    }

    public void setEndTrip(LocalDate endTrip) {
        this.endTrip = endTrip;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }


}
