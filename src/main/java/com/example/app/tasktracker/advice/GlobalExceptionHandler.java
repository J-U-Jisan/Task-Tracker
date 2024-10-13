package com.example.app.tasktracker.advice;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 * GlobalExceptionHandler is a centralized exception handling component
 * for Spring MVC applications. It captures exceptions thrown by
 * controllers and provides custom responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles MethodArgumentNotValidException, which occurs when
     * validation on an argument annotated with @Valid fails.
     *
     * @param ex the MethodArgumentNotValidException containing details
     *            about the validation error.
     * @return a ResponseEntity containing a detailed error message
     *         and an HTTP status code of BAD_REQUEST (400).
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        // Collects all field errors from the exception and formats them into a single string message.
        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ":" + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        // Returns a response with a BAD_REQUEST status and the error message.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    /**
     * Handles SQLException, which occurs during database operations.
     *
     * @param ex the SQLException containing details about the database error.
     * @return a ResponseEntity containing a detailed error message
     *         and an HTTP status code of INTERNAL_SERVER_ERROR (500).
     */
    public ResponseEntity<String> handleSQLException(SQLException ex) {
        String errorMessage = "Database error: " + ex.getMessage();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    /**
     * Handles general exceptions that are not specifically handled.
     *
     * @param ex the Exception containing details about the error.
     * @return a ResponseEntity containing a generic error message
     *         and an HTTP status code of INTERNAL_SERVER_ERROR (500).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralExceptions(Exception ex) {
        String errorMessage = "An unexpected error occurred: " + ex.getMessage();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
