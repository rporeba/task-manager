package com.rporeba.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by rporeba on 28.07.2016.
 */


@Component
public class ExternalConfigComponent {

    private static Logger logger = LoggerFactory.getLogger(ExternalConfigComponent.class);

    @Value("${property.one}")
    private String propertyOne;

    @Value("${property.two}")
    private String propertyTwo;

    @PostConstruct
    public void postConstruct(){

        logger.info("Property One: " + propertyOne);
        logger.info("Property Two: " + propertyTwo);

    }

}
