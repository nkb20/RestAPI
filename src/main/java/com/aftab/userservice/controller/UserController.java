package com.aftab.userservice.controller;

import com.aftab.userservice.entities.Users;
import com.aftab.userservice.payload.EmptyUsers;
import com.aftab.userservice.service.ServiceImplementation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class UserController {
    @Autowired
    ServiceImplementation serviceImplementation;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers() {
//        log.info("request Recieved");
        List<Users> user = serviceImplementation.getAllUsers();
        if (user.isEmpty()) {
            return new ResponseEntity( new EmptyUsers("Empty users","Add new Users "),HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<Users> setUsers(@RequestBody @Valid Users user) {
        Users use = serviceImplementation.setUsers(user);
        return new ResponseEntity<>(use, HttpStatus.ACCEPTED);
    }

    @GetMapping("/users/{id}")
        public ResponseEntity<Users> getUserById(@PathVariable int id) {

        return serviceImplementation.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
//        try {
//            String.valueOf(serviceImplementation.deleteUserById(id));
//            return new ResponseEntity("Deleted successfully",HttpStatus.ACCEPTED);
//        } catch (Exception e) {
//            return new ResponseEntity(e,HttpStatus.NOT_FOUND);
//        }
//        return ResponseEntity.ok(serviceImplementation.deleteUserById(id));
        return serviceImplementation.deleteUserById(id);

    }

}
