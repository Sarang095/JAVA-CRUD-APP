package com.joesalt.tutorial.service;

import com.joesalt.tutorial.model.Product;
import com.joesalt.tutorial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(long productId, Product product) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setColor(product.getColor());
        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
        return existingProduct;
    }

    public boolean deleteProduct(long productId) { // Fixed method return type
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return true;
        }
        return false; // Return false if product does not exist
    }

    public List<Product> getProductsByName(String productName) {
        return productRepository.getProductsByName(productName);
    }

    public List<Product> getProductsByUser(long userId) { // New method to retrieve products by userId
        // Implement your logic here based on how you store user-related products
        return productRepository.findByUserId(userId); // Example, you need to implement this query in ProductRepository
    }
}

