package ru.seraleu.irisky.web.dto.pprb.gigaChatDto.rq;

import java.util.List;

public record ChatCompletionRequest(
        String model,
        List<ChatMessage> messages,
        Integer n,
        Boolean stream,
        Integer max_tokens,
        Integer repetition_penalty,
        Integer update_interval
) {
    public record ChatMessage(String role, String content) {
    }
}