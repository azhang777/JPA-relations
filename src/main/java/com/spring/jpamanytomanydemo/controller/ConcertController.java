package com.spring.jpamanytomanydemo.controller;

import com.spring.jpamanytomanydemo.model.Artist;
import com.spring.jpamanytomanydemo.model.Concert;
import com.spring.jpamanytomanydemo.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ConcertController {

    @Autowired
    private ConcertService concertService;

    @PutMapping("/concerts")
    public ResponseEntity<?> addConcert(@Valid @RequestBody Concert concert) {
        return new ResponseEntity<>(concertService.addConcert(concert), HttpStatus.CREATED);
    }
    @GetMapping("/concerts")
    public ResponseEntity<Iterable<?>> getAllConcert() {
        return new ResponseEntity<>(concertService.getAllConcerts(), HttpStatus.OK);
    }
    @GetMapping("/concerts/{id}")
    public ResponseEntity<?> getSingleConcert(@PathVariable Long id) {
        return new ResponseEntity<>(concertService.getSingleConcert(id), HttpStatus.OK);
    }
    @PutMapping("/concerts/{id}")
    public ResponseEntity<?> updateConcert(@PathVariable Long id, @RequestBody Concert concert) {
        return new ResponseEntity<>(concertService.updateConcert(id, concert), HttpStatus.OK);
    }
    @DeleteMapping("/concerts/{id}")
    public ResponseEntity<?> deleteConcert(@PathVariable Long id) {
        concertService.deleteConcert(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
