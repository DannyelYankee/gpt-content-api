package com.daniel.gptcontentapi.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SummarizeResponse {
    private String summary;
}
