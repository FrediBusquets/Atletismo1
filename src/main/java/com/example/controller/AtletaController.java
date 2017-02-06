package com.example.controller;

import com.example.domain.Atleta;
import com.example.domain.TipoMedalla;
import com.example.domain.Medallas;
import com.example.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/atletas")
public class AtletaController {
    @Autowired
    private AtletaRepository atletaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atleta crearAtleta(@RequestBody Atleta atleta){
        return atletaRepository.save(atleta);
    }

    @GetMapping
    public List<Atleta> getAllAtleta(){
        return atletaRepository.findAll();
    }

    @PutMapping
    public Atleta updateAtleta(@RequestBody Atleta atleta){
        return atletaRepository.save(atleta);
    }

    @DeleteMapping("/{id}")
    public void deleteAtletaID(@PathVariable Long id){
        Atleta atleta = atletaRepository.findOne(id);
        if(atleta != null ) atletaRepository.delete(id);
    }


    @GetMapping("/GroupByNacionalidad")
    public Map<String, List<Atleta>> getAtletaGroupByNacionality(){
        return atletaRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(Atleta::getNacionalidad));
    }

    @GetMapping("/GroupByTipoMedalla")
    public Map<TipoMedalla, List<Atleta>> getAtletaGroupByTipoMedalla(){

        return atletaRepository.findAll().parallelStream().collect(groupingBy(athlete -> {
            if(athlete.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.Oro)){
                return TipoMedalla.Oro;
            }else if(athlete.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.Plata)){
                return TipoMedalla.Plata;
            }else if(athlete.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.Bronce)){
                return TipoMedalla.Bronce;
            }else {
                return TipoMedalla.Nada;
            }
        }));
    }

}
