package com.samrat.ms.core.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
@Slf4j
public class ProductController {

    @Value("${username}")
    private String username;

    @GetMapping(value = "/")
    public String index() {
        log.info("svc-product: Received request on index");
        return "Hello from svc-product. Property from Config Server is = " + username;
    }
}
