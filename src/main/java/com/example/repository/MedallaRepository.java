package com.example.repository;


import com.example.domain.Medallas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedallaRepository extends JpaRepository<Medallas, Long> {
}
