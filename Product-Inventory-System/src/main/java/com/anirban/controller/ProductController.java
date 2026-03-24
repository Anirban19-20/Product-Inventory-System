package com.anirban.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.anirban.entity.Product;
import com.anirban.entity.ResponseStructure;
import com.anirban.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {

    @Autowired
    private ProductService pserve;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<Product>> createProduct(@RequestBody Product product){
        return pserve.createProduct(product);
    }

    @GetMapping("/fetch")
    public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct(){
        return pserve.getAllProduct();
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<ResponseStructure<Optional<Product>>> getProductById(@PathVariable Long id){
        return pserve.getProductById(id);
    }

    // 🔥 PARTIAL UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseStructure<Product>> updateProductById(@RequestBody Product product, @PathVariable Long id){
        return pserve.updateProductById(product, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteProductById(@PathVariable Long id) {
        return pserve.deleteProductById(id);
    }
}