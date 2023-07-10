package com.aftab.userservice.service;

import com.aftab.userservice.entities.Users;
import com.aftab.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Users> getUserById(int id) {
        return userRepository.findById(id);


    }

    @Override
    public ResponseEntity deleteUserById(int id) {
        if (userRepository.findById(id).isEmpty()) {
            return new ResponseEntity("id not found", HttpStatus.NOT_FOUND);
        } else {
            userRepository.deleteById(id);

        }
        return new ResponseEntity("Id " + id + " deleted succesfully", HttpStatus.FOUND);

    }
}
