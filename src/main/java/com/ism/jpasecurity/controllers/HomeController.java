package com.ism.jpasecurity.controllers;

/**
 * Author  : essejacaues.co
 * Date    : 24/06/2023 02:30
 * Project : JpaSecurity
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/error")
    public String error() {
        return "error";
    }
}

