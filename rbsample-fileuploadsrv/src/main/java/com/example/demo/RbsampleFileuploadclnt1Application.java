package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@RestController
public class RbsampleFileuploadclnt1Application {
	
	private AtomicInteger counter = new AtomicInteger(10);

	public static void main(String[] args) {
		SpringApplication.run(RbsampleFileuploadclnt1Application.class, args);
	}
	
	@RequestMapping(value = "/uploadtest", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException{
		
		FileUtils.writeByteArrayToFile(new File("H:\\Workspace\\sts381_springFileUploadClt_ws\\rbsample-fileuploadsrv\\a\\"), file.getBytes());
		return "Success";
		
	}
	
	@PostMapping( value = "/upload", consumes = "multipart/form-data")
	public String upload(@RequestPart("name") String name, @RequestPart("file") MultipartFile file) throws IOException{
		
		int i = counter.incrementAndGet();
		String fname = i + name;
		FileUtils.writeByteArrayToFile(new File("H:\\Workspace\\sts381_springFileUploadClt_ws\\rbsample-fileuploadsrv\\b\\"+fname), file.getBytes());
		return "Success - "+ fname;		
	}
}
