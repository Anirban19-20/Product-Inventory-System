package com.anirban.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.anirban.entity.ResponseStructure;

@ControllerAdvice
public class ProductExceptionHandler {
	
	public ResponseEntity<ResponseStructure<String>> handlePNFE(ProductNotFoundException exception){
		ResponseStructure<String> structure= new ResponseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		structure.setData("Product Not Found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
