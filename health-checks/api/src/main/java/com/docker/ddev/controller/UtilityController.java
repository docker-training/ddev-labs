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
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unchecked")
    @RequestMapping(value="/healthcheck", method = RequestMethod.GET)
    public ResponseEntity<?> healthCheck() {
        logger.info("Performing healthcheck");
        JSONObject healthcheck = new JSONObject();
        try
        {
            String sql = "SELECT to_char(current_timestamp, 'YYYY-MM-DD HH24:MI')";
            String status = jdbcTemplate.queryForObject(sql, String.class);    		
            healthcheck.put("status", status);
        } catch (Exception e) {
            logger.warn("An exception occurred while checking the database: {}", e);
            return new ResponseEntity<Object>(new CustomErrorType("Database not responding."), 
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<JSONObject>(healthcheck, HttpStatus.OK);
    }
}