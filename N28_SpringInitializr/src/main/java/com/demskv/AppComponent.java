package com.demskv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppComponent {
    private static final Logger logger = LoggerFactory.getLogger(AppService.class);

    public void doSomething(){
        logger.debug("AppComponent - doSomething");
    }
}
