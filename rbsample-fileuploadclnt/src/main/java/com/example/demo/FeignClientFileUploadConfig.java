package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class FeignClientFileUploadConfig {

	@Bean
	public Contract useFeignAnnotations() {
	    return new Contract.Default();
	}
}
