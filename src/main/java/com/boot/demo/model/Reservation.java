package com.boot.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDate checkInDate;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDate checkOutDate;
    private Integer startTime;
    private Integer endTime;
    private Integer duration;
    private Integer numOfGuests;
    private Integer totalPrice;
    private String name;
    private Integer phoneNumber;
    private String boatType;
    @ManyToMany
    private List<Boat> arrayList=new ArrayList<>();
    @ManyToOne
    private Guest guest;
    @ManyToOne
    private Trip trip;


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

    public Integer getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(Integer numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    public List<Boat> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<Boat> arrayList) {
        this.arrayList = arrayList;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBoatType() {
        return boatType;
    }

    public void setBoatType(String boatType) {
        this.boatType = boatType;
    }
}
