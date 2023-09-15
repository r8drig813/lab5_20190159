package com.example.lab5_20190159.repository;

import com.example.lab5_20190159.entity.Lugares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LugaresRepository extends JpaRepository<Lugares, Integer> {
}
