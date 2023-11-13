package com.spring.jpamanytomanydemo.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "artists")
    private Set<Concert> concerts = new HashSet<>();

    public Artist() {
    }

    public Artist(Long id, String name, Set<Concert> concerts) {
        this.id = id;
        this.name = name;
        this.concerts = concerts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(Set<Concert> upcomingConcertId) {
        this.concerts = upcomingConcertId;
    }
}
