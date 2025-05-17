package com.daniel.gptcontentapi.dtos.client.response;

import com.daniel.gptcontentapi.dtos.client.Choice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpenAiResponse {
    private String id;
    private List<Choice> choices;
}
