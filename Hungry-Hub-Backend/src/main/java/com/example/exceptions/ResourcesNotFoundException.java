package com.example.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


public class ResourcesNotFoundException extends RuntimeException{
    public ResourcesNotFoundException() {
    }

    public ResourcesNotFoundException(String message) {
        super(message);
    }
}
