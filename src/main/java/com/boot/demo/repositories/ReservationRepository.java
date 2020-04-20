package com.boot.demo.repositories;

import com.boot.demo.model.Boat;
import com.boot.demo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    Reservation findOneByIdAndStartTime (Long id, Integer startTime);


}
