package com.perfumery.perfumerywebapp.controllers;

import com.perfumery.perfumerywebapp.models.Perfume;
import com.perfumery.perfumerywebapp.services.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/perfumes")
public class PerfumeController {

    @Autowired
    private PerfumeService perfumeService;

    @GetMapping("/all")
    public ResponseEntity<List<com.perfumery.perfumerywebapp.dtos.PerfumeDTO>> getAllPerfumes() {
        List<com.perfumery.perfumerywebapp.dtos.PerfumeDTO> perfumes = perfumeService.getAllPerfumes();

        return new ResponseEntity<>(perfumes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.perfumery.perfumerywebapp.dtos.PerfumeDTO> getPerfumeById(@PathVariable("id") Long id) {
        com.perfumery.perfumerywebapp.dtos.PerfumeDTO perfume = perfumeService.findPerfumeById(id);

        return new ResponseEntity<>(perfume, HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public ResponseEntity<com.perfumery.perfumerywebapp.dtos.PerfumeDTO> createPizza(@RequestBody Perfume pizza) {
//        com.perfumery.perfumerywebapp.dtos.PerfumeDTO newPizza = pizzaService.createPizza(pizza);
//
//        return new ResponseEntity<>(newPizza, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<com.perfumery.perfumerywebapp.dtos.PerfumeDTO> updatePizza(@PathVariable("id") Long id, @RequestBody Perfume pizza) {
//        com.perfumery.perfumerywebapp.dtos.PerfumeDTO updatedPizza = pizzaService.updatePizza(id, pizza);
//
//        return new ResponseEntity<>(updatedPizza, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deletePizza(@PathVariable("id") Long id) {
//        pizzaService.deletePizza(id);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
