package com.spring.jpamanytomanydemo.service;

import com.spring.jpamanytomanydemo.model.Concert;
import com.spring.jpamanytomanydemo.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertService {
    @Autowired
    private ConcertRepository concertRepository;

    public Concert addConcert(Concert concert) {
        return concertRepository.save(concert);
    }

    public Iterable<Concert> getAllConcerts() {
        return concertRepository.findAll();
    }

    public Concert getSingleConcert(Long id) {
        return concertRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Concert updateConcert(Long id, Concert updatedConcert) {
        Concert existingConcert = getSingleConcert(id);
        existingConcert.setEventName(updatedConcert.getEventName());
        existingConcert.setLocation(updatedConcert.getLocation());
        existingConcert.setDate(updatedConcert.getDate());

        return existingConcert;
    }

    public void deleteConcert(Long id) {
        Concert concertToDelete = getSingleConcert(id);
        concertRepository.delete(concertToDelete);
    }
}
