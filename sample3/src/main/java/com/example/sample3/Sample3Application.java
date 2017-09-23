package com.example.sample3;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Sample3Application {

	private AtomicInteger ai = new AtomicInteger();

	@RequestMapping(value = "/getNumber", produces = "application/json")
	public String produce() {
		return String.format("{\"value\": %s}", ai.incrementAndGet());
	}

	public static void main(String[] args) {
		SpringApplication.run(Sample3Application.class, args);
	}
}