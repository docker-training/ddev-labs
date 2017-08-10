package com.docker.ddev.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.docker.ddev.model.Image;
import com.docker.ddev.service.ImageService;
import com.docker.ddev.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class PetController {
	public static final Logger logger = LoggerFactory.getLogger(PetController.class);
	
	@Autowired
	ImageService imageService;

	// -------------------Retrieve Single Image By Id------------------------------------------

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pet", method = RequestMethod.GET)
	public ResponseEntity<?> getPet() {
		logger.info("Fetching random Pet");
        int max =imageService.count();
        long imageId = ThreadLocalRandom.current().nextInt(1, max+1);
		logger.info("Equals to fetching Image with Id {}", imageId);
		Image image = imageService.findById(imageId);
		if (image == null) {
			logger.error("Image with id {} not found.", imageId);
			return new ResponseEntity(new CustomErrorType("Image with id " + imageId 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Image>(image, HttpStatus.OK);
	}
}