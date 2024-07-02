package com.learnboot.flywayapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product{
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(insertable=false, updatable=false)
        private String orderNumber;
        private String productId;
        private String productType;
        private String SKU;
        private String price;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "orderNumber")
        private Order order;
}
