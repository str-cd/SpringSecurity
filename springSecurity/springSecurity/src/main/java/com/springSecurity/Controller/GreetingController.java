package com.springSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Security";
    }

    @GetMapping("/contact")
    public String contact(){
        return "Hello contact";
    }


}
