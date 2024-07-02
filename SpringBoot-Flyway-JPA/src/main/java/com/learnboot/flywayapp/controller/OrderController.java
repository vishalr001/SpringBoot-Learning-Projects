package com.learnboot.flywayapp.controller;

import com.learnboot.flywayapp.model.Order;
import com.learnboot.flywayapp.model.Product;
import com.learnboot.flywayapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orderRepo;


    @PostMapping("/addOrder")
    ResponseEntity<String> readOrderData(@RequestBody Order order){
        try {
//            Order orderObj = new Order();
//            orderObj.setOrderNumber(order.getOrderNumber());
//            orderObj.setOrderRefNumber(order.getOrderRefNumber());
//            orderObj.setOrderVersion(order.getOrderVersion());
//            orderObj.setOrderCreationDate(order.getOrderCreationDate());
//            orderObj.setProducts(order.getProducts());
            orderRepo.save(order);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Order data saved successfully!");
    }

    @GetMapping("/getOrder")
    ResponseEntity<Order> getOrderData(@RequestParam String orderNumber){
        Order order = orderRepo.findByOrderNumber(orderNumber);
        return ResponseEntity.ok().body(order);
    }
}
