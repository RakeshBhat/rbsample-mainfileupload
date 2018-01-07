package com.example.demo;

import java.io.File;
import java.nio.charset.Charset;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import feign.Response;

@Component
public class FeignFileUploadFallBack implements FileUploadClient{

	public Response uploadFile(String name, File file) {
		return Response.builder()
				.body("Unable to upload file", Charset.defaultCharset())
				.build();
	}

	public String handleFileUpload(MultipartFile file) {
		return "Unable to upload file";
	}

}
