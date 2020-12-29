package com.samrat.ms.core.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @GetMapping(value = "/")
    public String index() {
        log.info("Received request on index");
        return "Hello from Product Service!!";
    }
}
