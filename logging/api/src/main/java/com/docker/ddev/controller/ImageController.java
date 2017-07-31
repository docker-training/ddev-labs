package com.docker.ddev.controller;

import java.util.List;

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
public class ImageController {
	public static final Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	@Autowired
	ImageService imageService;

	// -------------------Retrieve All Images---------------------------------------------

	@RequestMapping(value = "/images/", method = RequestMethod.GET)
	public ResponseEntity<List<Image>> listAllImages() {
		List<Image> images = imageService.findAllImages();
		if (images.isEmpty()) {
			return new ResponseEntity<List<Image>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Image>>(images, HttpStatus.OK);
	}

	// -------------------Retrieve Single Image By Id------------------------------------------

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/images/{imageId}", method = RequestMethod.GET)
	public ResponseEntity<?> getImage(@PathVariable("imageId") long imageId) {
		logger.info("Fetching Image with id {}", imageId);
		Image image = imageService.findById(imageId);
		if (image == null) {
			logger.error("Image with id {} not found.", imageId);
			return new ResponseEntity(new CustomErrorType("Image with id " + imageId 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Image>(image, HttpStatus.OK);
	}
}