package com.daniel.gptcontentapi.controllers;

import com.daniel.gptcontentapi.dtos.SummarizeRequest;
import com.daniel.gptcontentapi.dtos.SummarizeResponse;
import com.daniel.gptcontentapi.services.SummarizerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
@AllArgsConstructor
public class ContentController {
    private SummarizerService summarizerService;


    /**
     * Summarizes the input text using the configured summarization service.
     *
     * @param request The incoming request containing the text to summarize.
     * @return The summarized text wrapped in a response object.
     */
    @PostMapping(value = "summarize")
    public ResponseEntity<SummarizeResponse> summarize(@Valid @RequestBody SummarizeRequest request) {

        final String summary = this.summarizerService.summarize(request.getText());
        return ResponseEntity.ok(SummarizeResponse.builder().summary(summary).build());

    }
}

