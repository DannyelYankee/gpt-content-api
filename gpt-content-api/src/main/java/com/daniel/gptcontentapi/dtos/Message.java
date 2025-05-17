package com.daniel.gptcontentapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    @NotBlank
    private String role;

    @NotBlank
    @Size(min = 10)
    private String content;

}
