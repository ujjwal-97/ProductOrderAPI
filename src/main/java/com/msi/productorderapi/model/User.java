package com.msi.productorderapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "USER101")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    @Column(name = "FIRST_NAME")
    String firstName;

    @Column(name= "LAST_NAME")
    String lastName;

    @Column(name = "AGE")
    Integer age;

    @OneToMany(fetch =  FetchType.EAGER,mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Order> orderList;

}
