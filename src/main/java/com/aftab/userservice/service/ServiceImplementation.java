package com.aftab.userservice.service;

import com.aftab.userservice.entities.Users;
import com.aftab.userservice.exceptions.ResourceNotFoundException;
import com.aftab.userservice.payload.ApiResponse;
import com.aftab.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;
//    List<Users> usersList = new ArrayList<>();

    @Override
    public Users setUsers(Users user) {
        return userRepository.save(user);

//        usersList.add(user);
//        return user;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<Users> getUserById(int id) {
        Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));
        return new ResponseEntity(user, HttpStatus.FOUND);

    }

    @Override
    public ResponseEntity deleteUserById(int id) {
        Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));

        userRepository.deleteById(id);
//        if (userRepository.findById(id).isEmpty()) {
//            return new ResourceNotFoundException("f","f",id);
//        } else {
//            userRepository.deleteById(id);
//
//        }
//        return new ResponseEntity("Id " + id + " deleted succesfully", HttpStatus.FOUND);
        return new ResponseEntity(new ApiResponse("Deleted Succesfully", true, LocalDate.now()), HttpStatus.ACCEPTED);
    }
}
