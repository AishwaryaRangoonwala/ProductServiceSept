package com.aishwarya.productservicesept.advices;

import com.aishwarya.productservicesept.dtos.ProductNotFoundErrorDTO;
import com.aishwarya.productservicesept.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundErrorDTO> handleProductNotFoundException(ProductNotFoundException e) {
        // code to handle the exception
        // beautifies the response
        ProductNotFoundErrorDTO errorDTO = new ProductNotFoundErrorDTO();
        errorDTO.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
