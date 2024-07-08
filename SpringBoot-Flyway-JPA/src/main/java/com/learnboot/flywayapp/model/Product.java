package com.learnboot.flywayapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String productId;
        private String productType;
        private String SKU;
        private String price;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "order_number", referencedColumnName = "order_number")
        private Order order;
}
