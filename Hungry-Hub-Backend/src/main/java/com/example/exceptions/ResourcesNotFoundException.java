package com.example.exceptions;

public class ResourcesNotFoundException extends RuntimeException{
    public ResourcesNotFoundException() {
    }

    public ResourcesNotFoundException(String message) {
        super(message);
    }
}
