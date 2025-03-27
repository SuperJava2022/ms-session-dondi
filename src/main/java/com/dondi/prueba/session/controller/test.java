package com.dondi.prueba.session.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class test {

    @GetMapping("/prueba/{param}")
    public String getMethodName(@PathVariable String param) {
        return new String("Bienvenido " + param);
    }

}
