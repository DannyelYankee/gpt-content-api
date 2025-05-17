package com.daniel.gptcontentapi.client;

import com.daniel.gptcontentapi.configuration.OpenAiClientConfig;
import com.daniel.gptcontentapi.constants.OpenAiFallbacks;
import com.daniel.gptcontentapi.constants.OpenAiPrompts;
import com.daniel.gptcontentapi.dtos.client.Choice;
import com.daniel.gptcontentapi.dtos.client.Message;
import com.daniel.gptcontentapi.dtos.client.Role;
import com.daniel.gptcontentapi.dtos.client.request.OpenAiRequest;
import com.daniel.gptcontentapi.dtos.client.response.OpenAiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class OpenAiClient {

    private final OpenAiClientConfig openAiClientConfig;


    public String getSummary(String prompt) {
        final OpenAiRequest request = createRequest(prompt);
        final OpenAiResponse response = processResponse(openAiClientConfig.openAiWebClient()
                .post()
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(OpenAiResponse.class));
        return response.getChoices().get(0).getMessage().getContent();
    }

    private OpenAiResponse processResponse(Mono<OpenAiResponse> openAiResponseMono) {
        final OpenAiResponse response = openAiResponseMono.block();
        if (response == null) {
            return OpenAiResponse.builder().build();
        }
        final List<Choice> choices = response.getChoices();

        if (choices.isEmpty()) {
            response.setChoices(emptyChoicesFallback());
        }
        return response;

    }

    private List<Choice> emptyChoicesFallback() {
        return Collections.singletonList(
                Choice.builder()
                        .message(
                                Message.builder()
                                        .content(OpenAiFallbacks.EMPTY_CHOICES)
                                        .build())
                        .build()
        );
    }

    private OpenAiRequest createRequest(String prompt) {
        return OpenAiRequest.builder()
                .model(openAiClientConfig.getOpenAiProperties().getModel())
                .messages(Arrays.asList(
                        getSystemMessage(),
                        getUserMessage(prompt)))
                .build();
    }

    private Message getSystemMessage() {
        return Message.builder()
                .role(Role.SYSTEM)
                .content(OpenAiPrompts.SYSTEM_SUMMARIZER)
                .build();
    }

    private Message getUserMessage(String prompt) {
        return Message.builder()
                .role(Role.USER)
                .content(prompt)
                .build();
    }

}
