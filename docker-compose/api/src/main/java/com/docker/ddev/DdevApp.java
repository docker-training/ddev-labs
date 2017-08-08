package com.docker.ddev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.docker.ddev.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.docker.ddev"})
@EntityScan("com.docker.ddev.model")
@EnableJpaRepositories("com.docker.ddev.repository")
public class DdevApp {
	public static void main(String[] args) {
		SpringApplication.run(DdevApp.class, args);
	}
}