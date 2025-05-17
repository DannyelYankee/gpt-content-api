package com.daniel.gptcontentapi.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "openai")
@Data
public class OpenAiProperties {
    private String apiKey;
    private String model;
    private String url;
}
