package com.aftab.userservice.repository;

import com.aftab.userservice.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

}
