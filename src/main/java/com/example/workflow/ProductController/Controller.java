package com.example.workflow.ProductController;

import com.example.workflow.model.dto.CreateProductDto;
import com.example.workflow.model.entities.Product;
import com.example.workflow.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class Controller {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<Product> create(@RequestBody CreateProductDto createProductDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(createProductDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id){
        //return ResponseEntity.ok().body(id);
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct(id));
    }


}
