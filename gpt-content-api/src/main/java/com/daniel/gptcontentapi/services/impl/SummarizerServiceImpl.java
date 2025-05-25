package com.daniel.gptcontentapi.services.impl;

import com.daniel.gptcontentapi.client.OpenAiClient;
import com.daniel.gptcontentapi.services.SummarizerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SummarizerServiceImpl implements SummarizerService {
    private final OpenAiClient openAiClient;

    @Override
    public String summarize(String text) {

        return openAiClient.getSummary(text);
    }
}
