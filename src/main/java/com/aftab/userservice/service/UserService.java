package com.aftab.userservice.service;

import com.aftab.userservice.entities.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public Users setUsers(Users users);

    public List<Users> getAllUsers();

    public ResponseEntity getUserById(int id);
    ResponseEntity deleteUserById(int id);
}
