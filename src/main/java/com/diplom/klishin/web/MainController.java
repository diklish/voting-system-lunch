package com.diplom.klishin.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @GetMapping("/")
    @ResponseBody
    public String greeting(Map<String, Object> model) {
        return "{\"success\":1, " +
                "\"message\": \"Main Page\"}";
    }

}
