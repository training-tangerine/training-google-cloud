package com.demo.api.FirebaseDatabase.controller;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.api.FirebaseDatabase.entity.User;
import com.demo.api.FirebaseDatabase.service.FirebaseDatabaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class FirebaseDatabaseController {

    @Autowired
    FirebaseDatabaseService firebaseDatabaseService;

    @GetMapping(value = "/check")
    public ResponseEntity<String> checkStatus(HttpServletRequest httpServletRequest, HttpServletResponse httpResponse) {
        
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public User getUserData(@PathVariable("id") String id ) throws InterruptedException, ExecutionException{
        return firebaseDatabaseService.getUserData(id);
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user ) throws InterruptedException, ExecutionException {
        return firebaseDatabaseService.createUser(user);
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody User user  ) throws InterruptedException, ExecutionException {
        return firebaseDatabaseService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") String id){
        return firebaseDatabaseService.deleteUser(id);
    }

}
