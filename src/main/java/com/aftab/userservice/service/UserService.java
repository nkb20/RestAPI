package com.aftab.userservice.service;

import com.aftab.userservice.entities.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public Users setUsers(Users users);

    public List<Users> getAllUsers();

    public Optional<Users> getUserById(int id);
    ResponseEntity deleteUserById(int id);
}
