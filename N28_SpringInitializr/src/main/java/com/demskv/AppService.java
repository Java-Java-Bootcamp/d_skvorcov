package com.demskv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    private static final Logger logger = LoggerFactory.getLogger(AppService.class);

    @Autowired
    AppComponent calculatorComponent;

    private AppService() {
    }

    public void doSomething(){
        logger.debug("AppService - doSomething");
    }
}
