package com.example.demo;

import java.io.File;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;

@FeignClient(name = "upload", url = "http://localhost:8081/", configuration = FeignClientFileUploadConfig.class, fallback = FeignFileUploadFallBack.class)
public interface FileUploadClient {

	@RequestLine("POST /upload")
	@Headers("Content-Type: multipart/form-data")
	Response uploadFile(@Param("name") String name, @Param("file") File file);
	
	//@RequestMapping(value = "/uploadtest", method = RequestMethod.POST)
	@RequestLine("POST /uploadtest")
	public String handleFileUpload(@RequestParam("file") MultipartFile file);

/*	void uploadmp3();

	void uploadpdf();

	void uploaddoc();*/
}
