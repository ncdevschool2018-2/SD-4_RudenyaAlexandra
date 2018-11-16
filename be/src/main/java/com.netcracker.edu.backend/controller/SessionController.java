package com.netcracker.edu.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionController {

    @GetMapping("/session")
    Long uid(HttpSession session) {
        return session.getLastAccessedTime();
    }

}
