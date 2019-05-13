package com.ecommnjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommnjt.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
