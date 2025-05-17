package com.daniel.gptcontentapi.services;

public interface SummarizerService {

    /**
     * Generates a summary based on the given input text.
     *
     * @param text The original text to summarize.
     * @return A summarized version of the input text.
     */
    String summarize(String text);
}
