package com.example.demo;

import java.io.File;

import org.springframework.stereotype.Service;

import feign.Feign;
import feign.Response;
import feign.form.FormEncoder;
import feign.jackson.JacksonEncoder;

@Service
public class FileUploadService {

	private static final String HTTP_FILE_UPLOAD_URL = "http://localhost:8081/";

	public boolean uploadFile(String fileName, File file) {

		FileUploadClient fileUploadResource = Feign.builder().encoder(new FormEncoder(new JacksonEncoder()))
				.target(FileUploadClient.class, HTTP_FILE_UPLOAD_URL);

		Response response = fileUploadResource.uploadFile(fileName, file);
		
		System.out.println("Server response: "+ response.body());
		
		return response.status() == 200;
	}

}
