package com.boot.demo.repositories;

import com.boot.demo.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip findByEndTrip(LocalDate endTrip);
}
