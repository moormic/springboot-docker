package com.moormic.springbootdocker.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping
    public String get() {
        return "Hello World!";
    }

    @GetMapping("/{name}")
    public String get(@PathVariable("name") String name) {
        return String.format("Hello %s!", name);
    }
}
