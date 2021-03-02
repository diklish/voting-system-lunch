package com.diplom.klishin.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vote")
    private Set<User> users;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vote")
    private Set<Restaurant> restaurants;

    public Vote() {
    }

    public Vote(@NotNull LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Vote(@NotNull LocalDateTime dateTime, Set<Restaurant> restaurant) {
        this.dateTime = dateTime;
        this.restaurants = restaurant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurant) {
        this.restaurants = restaurant;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
