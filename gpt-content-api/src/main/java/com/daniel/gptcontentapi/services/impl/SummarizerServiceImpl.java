package com.daniel.gptcontentapi.services.impl;

import com.daniel.gptcontentapi.services.SummarizerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SummarizerServiceImpl implements SummarizerService {


    @Override
    public String summarize(String text) {
        return String.format("%s%s", "Simulated summary from: ", text);
    }
}
