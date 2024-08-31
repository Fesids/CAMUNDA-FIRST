package com.example.workflow.delegate;

import com.example.workflow.model.entities.Product;
import com.example.workflow.repositories.ProductRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FindProduct implements JavaDelegate {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CamundaProductRep camundaProductRep;

    private final Logger LOGGER = LoggerFactory.getLogger(FindProduct.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Long productId = (Long) delegateExecution.getVariable("productId");

        System.out.println(productId);

        try{
            Product product = camundaProductRep.findProduct(productId);//productRepository.getReferenceById(productId);

            if(!Objects.isNull(product.getId())){
                delegateExecution.setVariable("productReturn", product);
            }
            else delegateExecution.setVariable("productReturn", "");

            LOGGER.info("Searching product"+ delegateExecution.getCurrentActivityName()+ " - "+productId);
        } catch (Exception e) {
            delegateExecution.setVariable("productReturn", "");
            LOGGER.info("error searching product"+ delegateExecution.getCurrentActivityName());
        }


    }
}
