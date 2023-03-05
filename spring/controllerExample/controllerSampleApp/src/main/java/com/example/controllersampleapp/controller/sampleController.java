package com.example.controllersampleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/sample")
public class sampleController {

    @GetMapping("/view1")
    public String testString(@RequestParam("number")int number){
        System.out.println("testString()");

        return "view"+number;
    }

    @GetMapping("/view2/{number}")
    public String testString2(@PathVariable int number) {
        System.out.println("testString2()");

        return "view"+number;
    }

    @GetMapping("/view3")
    public String testString3(@RequestBody int number) {
        System.out.println("testString3()");

        return "view"+number;
    }
}
