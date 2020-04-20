package com.boot.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Boat {
    @Id
    @GeneratedValue
    private Long id;
    private String boatNumber;
    private Integer boatPrice;
    private String boatType;
    private Integer boatNumberOfSeat;
    private Integer boatActualPrice;
    private Boolean available;


    @OneToMany
    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoatNumber() {
        return boatNumber;
    }

    public void setBoatNumber(String boatNumber) {
        this.boatNumber = boatNumber;
    }

    public Integer getBoatPrice() {
        return boatPrice;
    }

    public void setBoatPrice(Integer boatPrice) {
        this.boatPrice = boatPrice;
    }

    public String getBoatType() {
        return boatType;
    }

    public void setBoatType(String boatType) {
        this.boatType = boatType;
    }

    public Integer getBoatNumberOfSeat() {
        return boatNumberOfSeat;
    }

    public void setBoatNumberOfSeat(Integer boatNumberOfSeat) {
        this.boatNumberOfSeat = boatNumberOfSeat;
    }

    public Integer getBoatActualPrice() {
        return boatActualPrice;
    }

    public void setBoatActualPrice(Integer boatActualPrice) {
        this.boatActualPrice = boatActualPrice;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}