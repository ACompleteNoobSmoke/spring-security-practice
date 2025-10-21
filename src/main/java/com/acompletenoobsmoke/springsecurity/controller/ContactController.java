package com.acompletenoobsmoke.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/myContact")
    public String getMyContactDetails() {
        return "My Contact Details";
    }
}
