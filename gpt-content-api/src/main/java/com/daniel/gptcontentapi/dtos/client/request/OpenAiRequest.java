package com.daniel.gptcontentapi.dtos.client.request;

import com.daniel.gptcontentapi.dtos.client.Message;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpenAiRequest {
    @NotBlank
    private String model;

    private List<Message> messages;
}
