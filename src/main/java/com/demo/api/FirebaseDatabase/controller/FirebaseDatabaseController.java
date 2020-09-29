package com.demo.api.FirebaseDatabase.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.api.FirebaseDatabase.service.FirebaseDatabaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FirebaseDatabaseController {

    @Autowired
    FirebaseDatabaseService firebaseDatabaseService;

    @GetMapping(value = "/check")
    public ResponseEntity<String> checkStatus(HttpServletRequest httpServletRequest, HttpServletResponse httpResponse) {
        
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
