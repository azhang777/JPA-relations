package com.spring.jpamanytomanydemo;

import com.spring.jpamanytomanydemo.model.Artist;
import com.spring.jpamanytomanydemo.model.Concert;
import com.spring.jpamanytomanydemo.repository.ArtistRepository;
import com.spring.jpamanytomanydemo.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class JpaManyToManyDemoApplication implements CommandLineRunner {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private ConcertRepository concertRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaManyToManyDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        artistRepository.deleteAll();
        concertRepository.deleteAll();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.DECEMBER, 29);
        Concert concert = new Concert("HiJinx Festival", "Philadelphia, PA", calendar.getTime());

        Artist artist = new Artist("Porter Robinson");
        Artist artist1 = new Artist("Skrillex");

        concert.getArtistList().add(artist);
        concert.getArtistList().add(artist1);

        artist.getConcerts().add(concert);
        artist1.getConcerts().add(concert);

        concertRepository.save(concert);
    }
}
