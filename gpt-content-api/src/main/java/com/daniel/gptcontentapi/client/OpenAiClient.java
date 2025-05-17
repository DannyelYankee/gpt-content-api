package com.daniel.gptcontentapi.client;

import com.daniel.gptcontentapi.configuration.OpenAiClientConfig;
import com.daniel.gptcontentapi.dtos.Choice;
import com.daniel.gptcontentapi.dtos.Message;
import com.daniel.gptcontentapi.dtos.request.OpenAiRequest;
import com.daniel.gptcontentapi.dtos.response.OpenAiResponse;
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
    private final static String USER_ROLE = "user";
    private final static String SYSTEM_ROLE = "system";
    private final static String SYSTEM_CONTENT = "You are a helpful summarization assistant.";
    private final static String EMPTY_CHOICES_MSG = "There's been a problem with your prompt. Try again please.";
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
            response.setChoices(Collections.singletonList(
                    Choice.builder()
                            .message(
                                    Message.builder()
                                            .content(EMPTY_CHOICES_MSG)
                                            .build())
                            .build()
            ));
        }
        return response;

    }

    private OpenAiRequest createRequest(String prompt) {
        return OpenAiRequest.builder()
                .model(openAiClientConfig.getOpenAiProperties().getModel())
                .messages(Arrays.asList(
                        Message.builder().role(SYSTEM_ROLE).content(SYSTEM_CONTENT).build(),
                        Message.builder().role(USER_ROLE).content(prompt).build())).build();
    }

}
