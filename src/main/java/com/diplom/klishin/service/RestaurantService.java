package com.diplom.klishin.service;

import com.diplom.klishin.model.Restaurant;

import java.util.List;


public interface RestaurantService {

    Restaurant addRestaurant(Restaurant restaurant);

    List<Restaurant> getAll();

    Restaurant get(int id);

   void delete(long id);

    Restaurant getByName(String name);

    void update(Restaurant restaurant);

    //Restaurant editRestaurant(Restaurant restaurant);



}
