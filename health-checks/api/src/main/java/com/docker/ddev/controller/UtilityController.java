package com.docker.ddev.controller;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.docker.ddev.util.CustomErrorType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/utility/")
public class UtilityController {
    
    public static final Logger logger = LoggerFactory.getLogger(UtilityController.class);
    
    Boolean unhealthy = false;
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/simulate-failure", method = RequestMethod.GET)
    public ResponseEntity<String> simulateFailure() {
        unhealthy = true;
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
}