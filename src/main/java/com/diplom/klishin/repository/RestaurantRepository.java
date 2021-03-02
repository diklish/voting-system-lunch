package com.diplom.klishin.repository;

import com.diplom.klishin.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    // null if not found, when updated
    Restaurant saveAndFlush(Restaurant user);

    // null if not found
    Restaurant findById(int id);

    List<Restaurant> findAll();

    // false if not found
    boolean deleteById(int id);


    // null if not found
    Restaurant findByName(String name);



  /*  default Restaurant getWithMeals(int id) {
        throw new UnsupportedOperationException();
    }*/
}
