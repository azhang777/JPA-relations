package com.spring.jpamanytomanydemo.controller;

import com.spring.jpamanytomanydemo.model.Artist;
import com.spring.jpamanytomanydemo.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping("/artists")
    public ResponseEntity<?> addArtist(@Valid @RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.addArtist(artist), HttpStatus.CREATED);
    }

    @GetMapping("/artists")
    public ResponseEntity<Iterable<?>> getAllArtists() {
        return new ResponseEntity<>(artistService.getAllArtists(), HttpStatus.OK);
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<?> getArtist(@PathVariable Long id) {
        return new ResponseEntity<>(artistService.getSingleArtist(id), HttpStatus.OK);
    }

    @PutMapping("/artists/{id}")
    public ResponseEntity<?> updateArtist(@PathVariable Long id, @RequestBody Artist updatedArtist) {
        return new ResponseEntity<>(artistService.updateArtist(id, updatedArtist), HttpStatus.OK);
    }
    @DeleteMapping("/artists/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable Long id) {

        artistService.deleteArtist(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
