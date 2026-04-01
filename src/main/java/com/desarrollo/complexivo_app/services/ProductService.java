package com.desarrollo.complexivo_app.services;

import com.desarrollo.complexivo_app.models.Product;
import com.desarrollo.complexivo_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product){
        return this.productRepository.save(product);
    }
}
