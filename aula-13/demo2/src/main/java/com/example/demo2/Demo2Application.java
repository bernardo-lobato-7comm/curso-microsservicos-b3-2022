package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/tracing")

public class Demo2Application {
	@Autowired
	Tracer tracer;
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	@GetMapping
	public String tracing() throws InterruptedException {
		System.out.println("Another Client");
		tracer.currentSpan().name("new Span");
		Thread.sleep(1000);
		return "Another Client";
	}
}
