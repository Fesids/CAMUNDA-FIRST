package com.example.workflow.delegate;

import com.example.workflow.model.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "findProduct", url = "http://localhost:8080/product")
public interface CamundaProductRep  {

    @GetMapping(value = "/{id}")
    Product findProduct(@PathVariable("id") Long id);

}
