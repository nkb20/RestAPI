package com.aftab.userservice.repository;

import com.aftab.userservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {


}
