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
        @Column(name = "order_number")
        private String orderNumber;
        private String orderRefNumber;
        private String orderVersion;
        private Date orderCreationDate;

        @OneToMany(
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER
        )
        @JoinColumn(name = "order_number_fk", referencedColumnName = "order_number")
        private List<Product> Products;
}
