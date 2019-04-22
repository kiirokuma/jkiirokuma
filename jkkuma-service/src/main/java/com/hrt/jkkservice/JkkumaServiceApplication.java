package com.hrt.jkkservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JkkumaServiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JkkumaServiceApplication.class, args);

		SampleService sampleService = new SampleService();
		SampleInput input = new SampleInput();
		input.id = "A";
		SampleOutput output = sampleService.api01(input);

		System.out.println(output.meessage);
	}

}
