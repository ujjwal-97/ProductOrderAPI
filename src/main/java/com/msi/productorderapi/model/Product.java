package com.msi.productorderapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "PRODUCT_111")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    @NonNull
    @Column(name = "PRODUCT_NAME")
    String productName;

    @Column(name = "DESC")
    String description;

    @Column(name = "MODEL")
    String model;

    @OneToOne(fetch =  FetchType.EAGER,mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    Order order;

}
