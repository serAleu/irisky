package ru.seraleu.irisky.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.seraleu.irisky.web.dto.pprb.giga.rq.ChatCompletionRequest;
import ru.seraleu.irisky.web.dto.pprb.giga.rs.ChatCompletionResponse;

@FeignClient(name = "gigaChatClient", url = "https://gigachat.devices.sberbank.ru/api/v1")
public interface GigaChatClient {

    @PostMapping(value = "/chat/completions",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ChatCompletionResponse createChatCompletion(
            @RequestHeader("Authorization") String authorization,
            @RequestBody ChatCompletionRequest request
    );
}
