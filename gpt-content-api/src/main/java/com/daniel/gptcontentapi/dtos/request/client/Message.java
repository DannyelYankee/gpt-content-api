package com.daniel.gptcontentapi.dtos.request.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Message {
    @NotBlank
    private String role;

    @NotBlank
    @Size(min = 10)
    private String content;

}
