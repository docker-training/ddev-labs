package com.docker.ddev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.docker.ddev.model.Image;

@Repository
@Transactional
public interface ImageRepository extends JpaRepository<Image, Long> {
}