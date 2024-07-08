package com.learnboot.flywayapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnboot.flywayapp.model.Order;
import com.learnboot.flywayapp.model.Product;
import com.learnboot.flywayapp.repository.OrderRepository;
import com.learnboot.flywayapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    ProductRepository prodRepo;

    @Autowired
    ObjectMapper jackson2ObjectMapper;


    @PostMapping("/addOrder")
    ResponseEntity<String> readOrderData(@RequestBody Order order){
        try {
            //Create and set order instance
            Order orderObj = new Order();
            orderObj.setOrderNumber(order.getOrderNumber());
            orderObj.setOrderRefNumber(order.getOrderRefNumber());
            orderObj.setOrderVersion(order.getOrderVersion());
            orderObj.setOrderCreationDate(order.getOrderCreationDate());

            //Product is child entity of Order hence set Order instance in each prod of prodList
            List<Product> productList = new ArrayList<>(order.getProducts());
            productList.forEach(p -> p.setOrder(orderObj));

            //Order is parent entity hence set prodList in order instance
            orderObj.setProducts(productList);

            //Persist Order and Product in DB.
            orderRepo.save(orderObj);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok().body(e.getMessage());
        }

        return ResponseEntity.ok().body("Order data saved successfully!");
    }

    @GetMapping("/getOrder")
    ResponseEntity<String> getOrderData(@RequestParam String orderNumber) throws Exception {
        String response = "Order not found !";
        Order order = orderRepo.findByOrderNumber(orderNumber);
        try {
            if (order != null) {
                response = jackson2ObjectMapper.writeValueAsString(order);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body(response);
    }
}
