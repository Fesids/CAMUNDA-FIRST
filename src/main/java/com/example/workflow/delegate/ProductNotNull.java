package com.example.workflow.delegate;

import com.example.workflow.model.entities.Product;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductNotNull implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductNotNull.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Product product = (Product) delegateExecution.getVariable("productReturn");

        LOGGER.info("Searching not null Product"+ delegateExecution.getCurrentActivityName()+ " - "+ product);

    }
}
