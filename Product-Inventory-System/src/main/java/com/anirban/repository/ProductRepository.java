package com.anirban.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.anirban.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}
