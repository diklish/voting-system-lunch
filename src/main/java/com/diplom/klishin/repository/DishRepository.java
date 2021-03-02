package com.diplom.klishin.repository;

import com.diplom.klishin.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
