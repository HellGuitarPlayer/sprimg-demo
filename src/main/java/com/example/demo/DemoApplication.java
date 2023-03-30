package com.example.demo;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Crypto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		// qui nostro codice
		
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
//			jason come risposta di curl
			
			String parametroCrypto = "ETH-EUR";
			
			String response = restTemplate.getForObject(
					"https://api.coinbase.com/v2/prices/"+ parametroCrypto +"/spot", String.class);
			
			ObjectMapper mapper = new ObjectMapper();
			
		    JsonNode jsonNode = mapper.readTree(response);
	        JsonNode data = jsonNode.get("data");

	        Crypto mioCrypto = mapper.readValue(data.toString(), Crypto.class);
	        
			log.info(mioCrypto.toString());
		
	
			
		};
	}
}
