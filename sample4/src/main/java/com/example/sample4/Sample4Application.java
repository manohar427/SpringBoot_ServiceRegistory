package com.example.sample4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Sample4Application {

	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate rest;
    
	@RequestMapping(value = "/", produces = "application/json")
	public String produce() {
		String number = rest.getForObject("http://sample3/getNumber", String.class);
		System.out.println("NUMBER:::::::::::::::::::::::::::"+number);
		return number;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sample4Application.class, args);
	}
}