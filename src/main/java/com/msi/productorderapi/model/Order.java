package com.msi.productorderapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Access(AccessType.FIELD)
@NoArgsConstructor
@Table(name = "ORDER_100")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    @NonNull
    @Column(name = "Status")
    String status;

    @ManyToOne
    @JsonBackReference
    User user;

    @OneToOne
    @JsonBackReference
    Product product;
}
