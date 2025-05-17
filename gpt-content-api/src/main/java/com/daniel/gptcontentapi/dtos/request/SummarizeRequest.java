package com.daniel.gptcontentapi.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SummarizeRequest {

    @NotBlank
    @Size(min = 10)
    private String text;
}
