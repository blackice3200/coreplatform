package com.commestack.coreplatform.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @Value("${random.mapped.value}")
    private String randomMappedValue;

    @GetMapping("/")
        public String home() {
        return "home";
        }
    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

}
