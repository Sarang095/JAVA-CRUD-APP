package com.joesalt.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.joesalt.tutorial.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Query to fetch products by product name using a native SQL query
    @Query(value = "SELECT * FROM product_inventory WHERE product_name = ?1", nativeQuery = true)
    List<Product> getProductsByName(String productName);

    // New query to fetch products by userId using a native SQL query
    @Query(value = "SELECT * FROM product_inventory WHERE user_id = ?1", nativeQuery = true)
    List<Product> findByUserId(Long userId); // Assuming 'user_id' is a column in your product_inventory table
}