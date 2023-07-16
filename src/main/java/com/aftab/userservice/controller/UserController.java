package com.aftab.userservice.controller;

import com.aftab.userservice.entities.Users;
import com.aftab.userservice.payload.EmptyUsers;
import com.aftab.userservice.service.ServiceImplementation;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Filter;

@Slf4j
@RestController
public class UserController {
    @Autowired
    ServiceImplementation serviceImplementation;
//    @Autowired
//    ProductRepository productRepository;
//    @GetMapping("/users/product/{id}")
//    public List<Product> getAllProduct(@PathVariable int id) {
//               return productRepository.getAllProduct(id);
//    }


    @GetMapping("/users")
    public MappingJacksonValue getAllUsers() {
//        log.info("request Recieved");
        List<Users> user = serviceImplementation.getAllUsers();
//        if (user.isEmpty()) {
//            return new ResponseEntity(new EmptyUsers("Empty users", "Add new Users "), HttpStatus.NOT_FOUND);
//        }
       MappingJacksonValue mappingJacksonValue =new MappingJacksonValue(user);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","address","mobNo");
        FilterProvider filters= new SimpleFilterProvider().addFilter("SimpleFilter",filter);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;


//        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<Users> setUsers(@RequestBody @Valid Users user) {
        Users use = serviceImplementation.setUsers(user);
        return new ResponseEntity<>(use, HttpStatus.ACCEPTED);
    }

    @GetMapping("/users/{id}")
    public MappingJacksonValue getUserById(@PathVariable int id) {

       Users user= serviceImplementation.getUserById(id).getBody();

        MappingJacksonValue mappingJacksonValue =new MappingJacksonValue(user);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","address","mobNo","product");

        FilterProvider filters= new SimpleFilterProvider().addFilter("SimpleFilter",filter);

        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
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
