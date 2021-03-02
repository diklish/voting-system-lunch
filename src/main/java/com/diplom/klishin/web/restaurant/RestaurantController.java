package com.diplom.klishin.web.restaurant;

import com.diplom.klishin.model.Restaurant;
import com.diplom.klishin.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

import static com.diplom.klishin.util.exception.ValidationUtil.assureIdConsistent;
import static com.diplom.klishin.util.exception.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = RestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    static final String REST_URL = "/restaurants";

    @Autowired
    private RestaurantService service;

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("getAll");
        return service.getAll();
    }


    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> restaurants(@RequestBody Restaurant restaurant, Map<String, Object> model) {

        log.info("create {}", restaurant);
        checkNew(restaurant);
        Restaurant cretaedRestaurant = service.addRestaurant(restaurant);
        URI uriOfNewRestaurant = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(cretaedRestaurant.getId()).toUri();
        return ResponseEntity.created(uriOfNewRestaurant).body(cretaedRestaurant);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete {}", id);
        service.delete(id);
    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant, @PathVariable int id) {
        log.info("update {} with id={}", restaurant, id);
        assureIdConsistent(restaurant, id);
        service.update(restaurant);

    }

    @GetMapping("/by")
    public Restaurant getByName(@RequestParam String name) {
        log.info("getName {}", name);
        return service.getByName(name);
    }
}
