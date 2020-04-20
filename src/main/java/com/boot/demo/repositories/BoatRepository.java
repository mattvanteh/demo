package com.boot.demo.repositories;

import com.boot.demo.model.Boat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoatRepository extends JpaRepository<Boat, Long> {
    Boat findOneByBoatNumber(String boatNumber);
}
