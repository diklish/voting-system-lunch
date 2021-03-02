package com.diplom.klishin.web;

import com.diplom.klishin.model.Restaurant;
import com.diplom.klishin.model.Role;
import com.diplom.klishin.model.User;
import com.diplom.klishin.repository.UserRepository;
import com.diplom.klishin.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/registration")
    @ResponseBody
    public String registration(@RequestParam String name) {


        Restaurant byName = restaurantService.getByName(name);
        return "{\"success\":1" +
                "\"message\": \"Create user " + byName + "\"}";
    }

    @PostMapping(value = "/registration",
            headers = {"Content-type=application/json"})
    @ResponseBody
    public String addUser(@RequestBody User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByName(user.getName());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "{\"success\":1, " +
                    "\"message\": \"User exists!\"}";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userRepository.save(user);

        return "{\"success\":1" +
                "\"message\": \"Create user " + user.getName() + "\"}";
    }

    @PostMapping(value = "/perform_login",
            headers = {"Content-type=application/json"})
    @ResponseBody
    public String loginUser(@RequestBody User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByName(user.getName());

        if (userFromDb == null) {
            model.put("message", "User not exists!");
            return "{\"success\":-1, " +
                    "\"message\": \"The combination of password and login is incorrect!\"}";
        }

        return "{\"success\":1" +
                "\"message\": \"User authorizationed!" + user.getName() + "\"}";
    }

/*    @PostMapping(value = "/perform_login")
    @ResponseBody
    public String loginUser2(@RequestBody User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb == null) {
            model.put("message", "User not exists!");
            return "{\"success\":-1, " +
                    "\"message\": \"The combination of password and login is incorrect!\"}";
        }

        return "{\"success\":1" +
                "\"message\": \"User authorizationed!" + user.getUsername() + "\"}";
    }*/

    @GetMapping(value = "/doUserLogin",
            headers = {"Content-type=application/json"})
    @ResponseBody
    public String loginUser2(@RequestBody User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByName(user.getName());

        if (userFromDb == null) {
            model.put("message", "User not exists!");
            return "{\"success\":-1, " +
                    "\"message\": \"The combination of password and login is incorrect!\"}";
        }

        return "{\"success\":1" +
                "\"message\": \"User authorizationed!" + user.getName() + "\"}";
    }
}