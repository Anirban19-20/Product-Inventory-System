package com.anirban.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.anirban.entity.Product;
import com.anirban.entity.ResponseStructure;
import com.anirban.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository prepo;

    public ResponseEntity<ResponseStructure<Product>> createProduct(Product product){
        Product saved = prepo.save(product);

        ResponseStructure<Product> structure = new ResponseStructure<>();
        structure.setStatuscode(201);
        structure.setMessage("Product Created");
        structure.setData(saved);

        return ResponseEntity.status(201).body(structure);
    }

    public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct(){
        List<Product> list = prepo.findAll();

        ResponseStructure<List<Product>> structure = new ResponseStructure<>();
        structure.setStatuscode(200);
        structure.setMessage("All Products Fetched");
        structure.setData(list);

        return ResponseEntity.ok(structure);
    }

    public ResponseEntity<ResponseStructure<Optional<Product>>> getProductById(Long id){
        Optional<Product> optional = prepo.findById(id);

        ResponseStructure<Optional<Product>> structure = new ResponseStructure<>();
        structure.setStatuscode(200);
        structure.setMessage("Product Found");
        structure.setData(optional);

        return ResponseEntity.ok(structure);
    }

    // 🔥 MAIN LOGIC (IMPORTANT)
    public ResponseEntity<ResponseStructure<Product>> updateProductById(Product product, Long id){

        Optional<Product> optional = prepo.findById(id);
        ResponseStructure<Product> structure = new ResponseStructure<>();

        if(optional.isPresent()){

            Product existing = optional.get();

            // ✅ Only update non-null fields
            if(product.getCategory() != null)
                existing.setCategory(product.getCategory());

            if(product.getName() != null)
                existing.setName(product.getName());

            if(product.getPrice() != null)
                existing.setPrice(product.getPrice());

            if(product.getQuantity() != null)
                existing.setQuantity(product.getQuantity());

            if(product.getStatus() != null)
                existing.setStatus(product.getStatus());

            Product updated = prepo.save(existing);

            structure.setStatuscode(200);
            structure.setMessage("Product Updated Successfully");
            structure.setData(updated);

            return ResponseEntity.ok(structure);

        } else {
            structure.setStatuscode(404);
            structure.setMessage("Product Not Found");
            structure.setData(null);

            return ResponseEntity.status(404).body(structure);
        }
    }

    public ResponseEntity<ResponseStructure<String>> deleteProductById(Long id){

        prepo.deleteById(id);

        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatuscode(200);
        structure.setMessage("Product Deleted");
        structure.setData("Deleted Successfully");

        return ResponseEntity.ok(structure);
    }
}