package com.demo.api.FirebaseDatabase.controller;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.api.FirebaseDatabase.entity.User;
import com.demo.api.FirebaseDatabase.service.RealtimeDatabaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FirebaseDatabaseController {

    @Autowired
    RealtimeDatabaseService realtimeDatabaseService;

    @GetMapping(value = "/check")
    public ResponseEntity<String> checkStatus(HttpServletRequest httpServletRequest, HttpServletResponse httpResponse) {
        
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
