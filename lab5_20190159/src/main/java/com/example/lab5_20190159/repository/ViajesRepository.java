package com.example.lab5_20190159.repository;

import com.example.lab5_20190159.entity.Viajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajesRepository extends JpaRepository<Viajes, Integer> {
}
