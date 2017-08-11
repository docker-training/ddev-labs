
package com.docker.ddev.service;

import java.util.List;
import com.docker.ddev.model.Image;

public interface ImageService {
	List<Image> findAllImages();
	Image findById(Long productId);
	Long count();
}