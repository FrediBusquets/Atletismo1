package com.example.repository;

import com.example.domain.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {
    List<Atleta> findByNacionalidadIs(String nacionality);
    List<Atleta> findByfechaNacimientoBefore(LocalDate birthday);
    Atleta findByNombreIs(String nombre);
}
