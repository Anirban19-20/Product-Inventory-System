package com.anirban.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anirban.entity.Product;
import com.anirban.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository prepo;
	
	public Product createProduct(Product product) {
		return prepo.save(product);
	}
	
	public List<Product> getAllProduct(){
		return prepo.findAll();
	}
	
	public Optional<Product> getProductById(Long id){
		return prepo.findById(id);
	}
	
	public Product updateProductById(Product product, Long id) {
		return prepo.save(product);
	}
	
	public Boolean deleteProductById(Long id) {
		Optional<Product> recProduct= getProductById(id);
		
		if(recProduct.isPresent()) {
			prepo.delete(recProduct.get());
			return true;
		}
		else {
			return false;
		}
	}
}
