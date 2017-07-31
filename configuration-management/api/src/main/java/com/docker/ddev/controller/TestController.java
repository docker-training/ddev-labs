package com.docker.ddev.controller;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class TestController {
    public static final Logger logger = LoggerFactory.getLogger(TestController.class);
    
    Boolean unhealthy = false;

    @SuppressWarnings("unchecked")
    @RequestMapping(value="/show-config", method = RequestMethod.GET)
    public ResponseEntity<?> showConfig() {
        logger.info("Performing showConfig");

        JSONObject config = new JSONObject();
        config.put("APP_ENVIRONMENT", System.getenv("APP_ENVIRONMENT"));
        config.put("IMAGES_DIRECTORY", System.getenv("IMAGES_DIRECTORY"));
        config.put("PDF_DIRECTORY", System.getenv("PDF_DIRECTORY"));
        config.put("MIN_STOCK_COUNT", System.getenv("MIN_STOCK_COUNT"));
        return new ResponseEntity<JSONObject>(config, HttpStatus.OK);
    }
}