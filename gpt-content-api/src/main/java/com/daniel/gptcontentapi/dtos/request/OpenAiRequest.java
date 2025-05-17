package com.daniel.gptcontentapi.dtos.request;

import com.daniel.gptcontentapi.dtos.Message;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OpenAiRequest {
    @NotBlank
    private String model;

    private List<Message> messages;
}
