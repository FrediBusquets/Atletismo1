package com.example.service;

import com.example.domain.Medallas;
import com.example.domain.TipoMedalla;
import com.example.repository.AtletaRepository;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedallasService {
    @Autowired
    private MedallaRepository medallaRepository;
    @Autowired
    private AtletaRepository atletaRepository;
public void crearMedalla() {
    Medallas medalla1 = new Medallas("100 metros lisos", "Juegos Olimpicos 2012", TipoMedalla.Oro);
    medalla1.setAtleta(atletaRepository.findByNombreIs("Alejandro"));
    medallaRepository.save(medalla1);
    Medallas medalla2 = new Medallas("100 metros lisos", "Juegos Olimpicos 2012", TipoMedalla.Plata);
    medalla1.setAtleta(atletaRepository.findByNombreIs("Alberto"));
    medallaRepository.save(medalla2);
    Medallas medalla3 = new Medallas("100 metros lisos", "Juegos Olimpicos 2012", TipoMedalla.Bronce);
    medalla1.setAtleta(atletaRepository.findByNombreIs("Xavier"));
    medallaRepository.save(medalla3);
    Medallas medalla4 = new Medallas("100 metros mariposa", "Juegos Olimpicos 2012", TipoMedalla.Oro);
    medalla1.setAtleta(atletaRepository.findByNombreIs("Ivan"));
    medallaRepository.save(medalla4);
    Medallas medalla5 = new Medallas("100 metros mariposa", "Juegos Olimpicos 2012", TipoMedalla.Plata);
    medalla1.setAtleta(atletaRepository.findByNombreIs("Victor"));
    medallaRepository.save(medalla5);
    Medallas medalla6 = new Medallas("100 metros mariposa", "Juegos Olimpicos 2012", TipoMedalla.Bronce);
    medalla1.setAtleta(atletaRepository.findByNombreIs("Francisco"));
    medallaRepository.save(medalla6);
}
public void testMedalla(){}
}
