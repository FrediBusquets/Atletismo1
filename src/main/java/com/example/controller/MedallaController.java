package com.example.controller;

import com.example.domain.Medallas;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by USER on 09/12/2016.
 */
@RestController
@RequestMapping("/medallas")
public class MedallaController {
    @Autowired
    private MedallaRepository medallaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medallas createMedalla(@RequestBody Medallas medallas){
        return medallaRepository.save(medallas);
    }

    @GetMapping
    public List<Medallas> getAllMedallas(){
        return medallaRepository.findAll();
    }

    @PutMapping
    public Medallas updateMedallas(@RequestBody Medallas medallas){
        return medallaRepository.save(medallas);
    }

    @DeleteMapping("/{id}")
    public void deleteMedallasID(@PathVariable Long id){
        Medallas medallas = medallaRepository.findOne(id);
        if(medallas != null ) medallaRepository.delete(id);
    }

}
