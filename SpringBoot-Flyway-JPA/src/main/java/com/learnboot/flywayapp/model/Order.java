package com.learnboot.flywayapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ORDER_HEADER")
public class Order{
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String orderNumber;
        private String orderRefNumber;
        private String orderVersion;
        private Date orderCreationDate;

        @OneToMany(mappedBy = "order",
                orphanRemoval = true,
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
        private List<Product> Products;
}
