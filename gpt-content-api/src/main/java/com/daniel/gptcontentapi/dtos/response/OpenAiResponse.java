package com.daniel.gptcontentapi.dtos.response;

import com.daniel.gptcontentapi.dtos.Choice;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OpenAiResponse {
    private String id;
    private List<Choice> choices;
}
