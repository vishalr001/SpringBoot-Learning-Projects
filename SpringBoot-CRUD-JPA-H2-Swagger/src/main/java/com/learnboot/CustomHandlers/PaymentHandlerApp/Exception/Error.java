package com.learnboot.CustomHandlers.PaymentHandlerApp.Exception;

import java.util.Date;

public class Error {
    private Date timestamp;
    private String message;
    private String description;

    public Error(Date timestamp, String message, String description) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
