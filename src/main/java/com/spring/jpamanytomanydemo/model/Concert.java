package com.spring.jpamanytomanydemo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name = "concert")
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "event_name")
    @NotBlank
    private String eventName;

    @Column(name = "location")
    @NotBlank
    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "booking",
            joinColumns = @JoinColumn(name = "concert_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<Artist> artists = new HashSet<>();

    public Concert() {
    }

    public Concert(String eventName, String location, Date date) {
        this.eventName = eventName;
        this.location = location;
        this.date = date;
    }

    public Concert(Long id, String eventName, String location, Date date, Set<Artist> artistList) {
        this.id = id;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.artists = artistList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Artist> getArtistList() {
        return artists;
    }

    public void setArtistList(Set<Artist> artistList) {
        this.artists = artistList;
    }
}
