package com.example.demo;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SpringFileUploadScheduleConfig {
	
	@Autowired
	FileUploadService fileUploadService;
	
	@Value(value = "classpath:files/Kalimba.mp3")
	private Resource mp3;
	
	@Value(value = "classpath:files/github-git-cheat-sheet.pdf")
	private Resource pdf;
	
	@Value(value = "classpath:files/jls9.pdf")
	private Resource pdf4k;

	@Scheduled(fixedDelay = 1000, initialDelay = 1000)
	public void scheduleFixedRateWithInitialDelayTask_mp3() throws IOException {
	  
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "Fixed rate task with one second initial delay - " + now);
	    
        File file = mp3.getFile();
	    
	    fileUploadService.uploadFile("Kalimba.mp3", file);
	}
	
	@Scheduled(fixedDelay = 1000, initialDelay = 1000)
	public void scheduleFixedRateWithInitialDelayTask_pdf() throws IOException {
	  
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "Fixed rate task with one second initial delay - " + now);
	    
        File file = pdf.getFile();
        
	    fileUploadService.uploadFile("github-git-cheat-sheet.pdf", file);
	}
	
	@Scheduled(fixedDelay = 1000, initialDelay = 1000)
	public void scheduleFixedRateWithInitialDelayTask_doc() throws IOException {
	  
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "Fixed rate task with one second initial delay - " + now);
	    
	    //Resource resource = resourceLoader.getResource("classpath:files/jls9.pdf");
        File file = pdf4k.getFile();
        
	    fileUploadService.uploadFile("jls9.pdf", file);
	}
}
