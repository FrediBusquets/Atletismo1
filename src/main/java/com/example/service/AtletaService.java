package com.example.service;

import com.example.domain.Atleta;
import com.example.repository.AtletaRepository;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class AtletaService {
    @Autowired
    private AtletaRepository atletaRepository;
    @Autowired
    private MedallaRepository medallaRepository;

    public void crearAtleta() {
        Atleta francisco = new Atleta("Francisco", "Gomez", "España", LocalDate.of(2001, 10, 10));
        atletaRepository.save(francisco);
        Atleta alejandro = new Atleta("Alejandro", "Pellejero", "España", LocalDate.of(1994, 7, 1));
        atletaRepository.save(alejandro);
        Atleta victor = new Atleta("Victor", "Castro", "España", LocalDate.of(1996, 11, 12));
        atletaRepository.save(victor);
        Atleta xavier = new Atleta("Xavier", "Albalat", "Ruso", LocalDate.of(1992, 8, 11));
        atletaRepository.save(xavier);
        Atleta Ivan = new Atleta("Ivan", "Puchades", "Albania", LocalDate.of(1989, 1, 23));
        atletaRepository.save(Ivan);
        Atleta alberto = new Atleta("Alberto", "Pellejero", "Albania", LocalDate.of(1987, 2, 17));
        atletaRepository.save(alberto);

    }
    public void testAtleta(){
        System.out.println(atletaRepository.findByNacionalidadIs("Albania"));
        System.out.println(atletaRepository.findByfechaNacimientoBefore(LocalDate.of(1992, 8, 11)));
    }
}
