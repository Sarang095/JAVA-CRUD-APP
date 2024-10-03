package com.joesalt.tutorial.controller;

import com.joesalt.tutorial.model.Product;
import com.joesalt.tutorial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Insert a product into the database
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Get a single product by its id
    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "productId") long productId) {
        Product product = productService.getProduct(productId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get all products in the table in the database
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        if (!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Update an existing product in the database
    @PatchMapping("/product/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable(name = "productId") long productId, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(productId, product);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete an existing product in the database
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "productId") long productId) {
        boolean isDeleted = productService.deleteProduct(productId); // Fixed method name here
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get products by name using a raw SQL statement
    @GetMapping("/products-by-name")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam(name = "productName") String productName) {
        List<Product> products = productService.getProductsByName(productName);
        if (!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Additional route: To demonstrate integration with AuthService
    @GetMapping("/product/user/{userId}")
    public ResponseEntity<List<Product>> getProductsByUser(@PathVariable(name = "userId") long userId) {
        List<Product> userProducts = productService.getProductsByUser(userId); // Ensure this method is implemented in ProductService
        if (!userProducts.isEmpty()) {
            return new ResponseEntity<>(userProducts, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}