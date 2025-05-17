package com.daniel.gptcontentapi;

import com.daniel.gptcontentapi.configuration.OpenAiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(OpenAiProperties.class)
public class GptContentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GptContentApiApplication.class, args);
	}

}
