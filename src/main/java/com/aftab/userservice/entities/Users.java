package com.aftab.userservice.entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@JsonFilter("SimpleFilter")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_service")
public class Users {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String mobNo;

//    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fc_p_id",referencedColumnName = "id")
    private List<Product> product;
}
