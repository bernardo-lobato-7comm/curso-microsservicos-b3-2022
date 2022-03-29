package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zipkin2.Span;

@SpringBootApplication
@RestController
@RequestMapping("/tracing")

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public String tracing() {
		System.out.println("New Tracing...");
		return "New Tracing";
	}

	@GetMapping("/distribuido")
	public String dist() throws InterruptedException {
		System.out.println("New Distribuited Tracing...");

		final String uri = "http://localhost:9001/tracing";
		String result = restTemplate().getForObject(uri, String.class);
		restTemplate().getForObject(uri, String.class);
		restTemplate().getForObject(uri, String.class);
		this.sleep();
		restTemplate().getForObject(uri, String.class);
		restTemplate().getForObject(uri, String.class);




		return result;
	}

	@NewSpan("sleepSpan")
	public void sleep() throws InterruptedException {
		Thread.sleep(3000);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
