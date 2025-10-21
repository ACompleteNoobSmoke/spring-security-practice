package com.acompletenoobsmoke.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/myNotice")
    public String getMyLoanDetails() {
        return "My Loan Details";
    }
}
