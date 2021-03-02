package com.diplom.klishin.service.impl;

import com.diplom.klishin.model.Restaurant;
import com.diplom.klishin.repository.RestaurantRepository;
import com.diplom.klishin.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.diplom.klishin.util.exception.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {

        Restaurant saveRestaurant = repository.saveAndFlush(restaurant);

        return saveRestaurant;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    public Restaurant getByName(String name) {
        return repository.findByName(name);
    }

   /* @Override
    public Restaurant editRestaurant(Restaurant restaurant) {
        return repository.saveAndFlush(restaurant);
    }*/


    @Override
    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    @Override
    public Restaurant get(int id) {
        return checkNotFoundWithId(repository.findById(id), id);
    }

    //  @CacheEvict(value = "Restaurant", allEntries = true)
    @Override
    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "Restaurant must not be null");
        checkNotFoundWithId(repository.saveAndFlush(restaurant), restaurant.getId());
    }
}
