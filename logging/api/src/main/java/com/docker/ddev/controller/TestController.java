package com.docker.ddev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController{
    @RequestMapping(value = "/factorial/{number}", method = RequestMethod.GET)
    public ResponseEntity<String> getFactorial(@PathVariable("number") long number) {
        Long fac = calcFactorial(number);
        return new ResponseEntity<String>(Long.toString(fac), HttpStatus.OK);
    }

    private Long calcFactorial(long number){
        if(number == 1) return number;
        return number * calcFactorial(number-1);
    }
}