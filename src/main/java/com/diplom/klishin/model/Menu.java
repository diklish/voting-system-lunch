package com.diplom.klishin.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "price", nullable = false)
    @NotBlank
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "dish_id", nullable = false)
    @NotNull
    private Dish dish;


    @ManyToMany
    @JoinTable(name = "menu_restaurant",
            joinColumns = @JoinColumn(name="menu_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="restaurant_id", referencedColumnName="id")
    )
    private Set<Restaurant> restaurant;

    public Menu() {
    }

    public Menu(@NotNull LocalDateTime dateTime, @NotBlank Double price, @NotNull Dish dish, Set<Restaurant> restaurant) {
        this.dateTime = dateTime;
        this.price = price;
        this.dish = dish;
        this.restaurant = restaurant;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Set<Restaurant> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Set<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }
}
