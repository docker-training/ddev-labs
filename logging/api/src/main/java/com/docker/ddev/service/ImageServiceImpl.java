package com.docker.ddev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.docker.ddev.model.Image;
import com.docker.ddev.repositories.ImageRepository;

@Service("imageService")
@Transactional
public class ImageServiceImpl implements ImageService {
	@Autowired
	private ImageRepository imageRepository;

	public List<Image> findAllImages() {
		return imageRepository.findAll();
	}

	public Image findById(Long imageId) {
		return imageRepository.findOne(imageId);
	}

	public Long count(){
		return imageRepository.count();
	}
}