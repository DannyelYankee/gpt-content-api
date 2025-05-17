package com.daniel.gptcontentapi.dtos.request.client;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class OpenAiRequest {
    @NotBlank
    private String model;

    private List<Message> messages;
}
