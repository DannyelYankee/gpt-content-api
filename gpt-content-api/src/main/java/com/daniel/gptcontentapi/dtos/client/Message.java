package com.daniel.gptcontentapi.dtos.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    @NotBlank
    private Role role;

    @NotBlank
    @Size(min = 10)
    private String content;

}
