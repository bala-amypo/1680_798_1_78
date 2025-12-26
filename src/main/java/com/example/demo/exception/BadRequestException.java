package com.example.demo.exception;

/**
 * Custom exception used across services
 * to indicate invalid input or illegal operations.
 *
 * This is explicitly asserted in TestNG test cases.
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}







// package com.example.demo.exception;

// public class BadRequestException extends RuntimeException {

//     public BadRequestException(String message) {
//         super(message);
//     }
// }
