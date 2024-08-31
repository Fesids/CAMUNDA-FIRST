package com.example.workflow.service;

import com.example.workflow.model.dto.CreateProductDto;
import com.example.workflow.model.entities.Product;
import com.example.workflow.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product createProduct(CreateProductDto createProductDto) {

        Product newProd = Product.builder().name(createProductDto.name())
                .description(createProductDto.description())
                .build();
        return productRepository.save(newProd);

    }

    public Product getProduct(Long id) {
        return productRepository.getById(id);
    }

}
