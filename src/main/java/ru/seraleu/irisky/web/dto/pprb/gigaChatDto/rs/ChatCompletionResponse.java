package ru.seraleu.irisky.web.dto.pprb.gigaChatDto.rs;

import java.util.List;

public record ChatCompletionResponse(
        List<Choice> choices,
        long created,
        String model,
        String object,
        Usage usage
) {
    public record Choice(
            Message message,
            int index,
            String finish_reason
    ) {}

    public record Message(
            String content,
            String role
    ) {}

    public record Usage(
            int prompt_tokens,
            int completion_tokens,
            int total_tokens,
            int precached_prompt_tokens
    ) {}
}
