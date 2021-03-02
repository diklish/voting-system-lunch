package com.diplom.klishin.service.impl;

import com.diplom.klishin.model.Restaurant;
import com.diplom.klishin.service.RestaurantService;
import com.diplom.klishin.util.RestaurantUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
@ActiveProfiles("development")
public class RestaurantServiceImplTest {

    /*@Resource
    private EntityManagerFactory emf;
    protected EntityManager em;*/

    @Autowired
    private RestaurantService restaurantService;


    @Before
    public void setUp() throws Exception {
        //     em = emf.createEntityManager();
    }

    @Test
    public void addRestaurant() {
        Restaurant restaurant=restaurantService.addRestaurant(RestaurantUtil.createRestaurant());
        Assert.assertNotNull(restaurant);
    }

    @Test
    public void delete() {
    }

    @Test
    public void getByName() {
    }

    @Test
    public void editRestaurant() {
    }

    @Test
    public void getAll() {
    }
}