package com.spring.jpamanytomanydemo.service;

import com.spring.jpamanytomanydemo.model.Artist;
import com.spring.jpamanytomanydemo.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;
    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Iterable<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Artist getSingleArtist(Long id) {
        return artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Not available, make better exceptions idiot"));
    }

    public Artist updateArtist(Long id, Artist updatedArtist) {
        Artist existingArtist = artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Not available, make better exceptions idiot"));
        existingArtist.setName(updatedArtist.getName());
        existingArtist.setConcerts(updatedArtist.getConcerts());

        return existingArtist;
    }

    public void deleteArtist(Long id) {
        Artist existingArtist = getSingleArtist(id);
        artistRepository.delete(existingArtist);
    }

}
