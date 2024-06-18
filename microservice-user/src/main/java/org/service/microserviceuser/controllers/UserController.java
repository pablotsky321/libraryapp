package org.service.microserviceuser.controllers;

import jakarta.validation.Valid;
import org.service.microserviceuser.entities.UserEntity;
import org.service.microserviceuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(userService.findUserById(id), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> getUserByEmail(@RequestParam("email") String email) {
        try {
            return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByDoc")
    public ResponseEntity<?> getUserByDoc(@RequestParam("doc") String doc) {
        try {
            return new ResponseEntity<>(userService.findUserByDoc(doc), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserEntity user) {
        try {
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserEntity user) {
        try {
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
