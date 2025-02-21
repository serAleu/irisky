package ru.seraleu.irisky.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.seraleu.irisky.config.GigaChatProperties;
import ru.seraleu.irisky.web.dto.pprb.giga.rq.ChatCompletionRequest;
import ru.seraleu.irisky.web.dto.pprb.giga.rs.ChatCompletionResponse;
import ru.seraleu.irisky.web.dto.pprb.giga.rs.OAuthResponse;
import ru.seraleu.irisky.web.feign.GigaChatClient;
import ru.seraleu.irisky.web.gigachat.client.GigaOAuthClient;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class GigachatService {

    private final GigaOAuthClient gigaOAuthClient;
    private final GigaChatClient gigaChatClient;
    private final GigaChatProperties properties;

    private static long TOKEN_VALIDITY_TIME = 0L;
    private static String TOKEN = null;

    public String askGigaQuestion(String prompt) {
        // Проверяем валидность токена
        isTokenValid(TOKEN_VALIDITY_TIME);

        // Формируем запрос
        ChatCompletionRequest request = new ChatCompletionRequest(
                //GigaChat Lite 
                "GigaChat",
                List.of(new ChatCompletionRequest.ChatMessage("user", prompt)),
                1,
                false,
                100,
                1,
                0
        );

        ChatCompletionResponse response =
                gigaChatClient.createChatCompletion("Bearer " + TOKEN, request);
        return response.choices().get(0).message().content();
    }

    private OAuthResponse requestAccessToken() {
        Map<String, Object> form = new HashMap<>();
        form.put("scope", "GIGACHAT_API_PERS");
        return gigaOAuthClient.getAccessToken(
                "c9f625be-9ee9-4c4c-a01e-9effd495050e", "Basic " + "ZjA0ODllYWMtNzY0NS00OWZjLWJiNDctZTQzZWRmMTkwNzMyOjgwZTE3MDIyLTQxNjktNDg3Mi04NDYzLTJhNDZmNWNlNDE3Nw==", form).getBody();
    }

    private void isTokenValid(long time) {
        if (Instant.now().toEpochMilli() >= time) {
            OAuthResponse oAuthResponse = requestAccessToken();
            TOKEN_VALIDITY_TIME = Long.parseLong(oAuthResponse.expires_at());
            TOKEN = oAuthResponse.access_token();
            log.info("Токен обновлен.");
        }
        log.info("Токен валидный.");
    }
}