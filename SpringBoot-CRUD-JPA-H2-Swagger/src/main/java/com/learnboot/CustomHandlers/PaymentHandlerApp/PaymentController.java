package com.learnboot.CustomHandlers.PaymentHandlerApp;

import com.learnboot.CustomHandlers.PaymentHandlerApp.Exception.PaymentResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping("/transaction")
    public List<Payment> all(){
        return paymentRepository.findAll();
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<Payment> all(@PathVariable(value = "id") String transactionId)
            throws PaymentResourceNotFoundException {
        Payment payment = paymentRepository.findByTransactionId(transactionId);
        if(payment == null){
            throw new PaymentResourceNotFoundException("Transaction details not found: " + transactionId);
        }
        return ResponseEntity.ok().body(payment);
    }

    @PostMapping("/transaction")
    public Payment addPaymentDetails(@RequestBody Payment payment){
        return paymentRepository.save(payment);
    }

    @PutMapping("/transaction/{id}")
    public ResponseEntity<Payment> updatePaymentDetails(
            @PathVariable(value = "id") String transactionId, @Valid @RequestBody Payment paymentDetails)
            throws PaymentResourceNotFoundException{
        Payment payment = paymentRepository.findByTransactionId(transactionId);
        if(payment == null){
            throw new PaymentResourceNotFoundException("Transaction details not found: " + transactionId);
        }
        payment.setTransactionId(paymentDetails.getTransactionId());
        payment.setPaymentType(paymentDetails.getPaymentType());
        payment.setDestination(paymentDetails.getDestination());
        payment.setSource(paymentDetails.getSource());

        final Payment updatedPayment = paymentRepository.save(payment);
        return ResponseEntity.ok().body(updatedPayment);
    }

    @DeleteMapping("/transaction/{id}")
    public String deletePayment(@PathVariable(value = "id") String transactionId) throws PaymentResourceNotFoundException{
        Payment payment = paymentRepository.findByTransactionId(transactionId);
        if(payment == null){
            throw new PaymentResourceNotFoundException("Transaction details not found: " + transactionId);
        }
        paymentRepository.delete(payment);
        return "Payments details with transacton id : "+transactionId+" deleted successfully.";
    }
}
