package com.learnboot.CustomHandlers.PaymentHandlerApp.Exception;

public class PaymentResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public PaymentResourceNotFoundException(String message){
        super(message);
    }
}
