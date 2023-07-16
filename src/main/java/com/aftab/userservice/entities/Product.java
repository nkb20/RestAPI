package com.aftab.userservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    private int pId;
    private String pName;
    private int Qnty;

//    @OneToOne(mappedBy = "product")
//    private Users users;
}
