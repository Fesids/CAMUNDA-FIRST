package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductNull implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductNull.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Searching Product"+delegateExecution.getCurrentActivityName()+ " its null");
    }
}
