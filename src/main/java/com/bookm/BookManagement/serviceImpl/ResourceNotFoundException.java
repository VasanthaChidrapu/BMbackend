package com.bookm.BookManagement.serviceImpl;

public class ResourceNotFoundException extends RuntimeException{
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
