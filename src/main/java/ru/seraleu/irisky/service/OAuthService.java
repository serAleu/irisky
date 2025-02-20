package ru.seraleu.irisky.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.seraleu.irisky.config.GigaChatProperties;
import ru.seraleu.irisky.web.dto.pprb.gigaChatDto.rq.ChatCompletionRequest;
import ru.seraleu.irisky.web.dto.pprb.gigaChatDto.rs.ChatCompletionResponse;
import ru.seraleu.irisky.web.dto.pprb.gigaChatDto.rs.OAuthResponse;
import ru.seraleu.irisky.web.feign.GigaChatClient;
import ru.seraleu.irisky.web.feign.SberOAuthClient;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Slf4j
@Service
public class OAuthService {

    private final SberOAuthClient sberOAuthClient;
    private final GigaChatClient gigaChatClient;
    private final GigaChatProperties properties;

    private static long TOKEN_VALIDITY_TIME = 0L;
    private static String TOKEN = null;


    @Autowired
    public OAuthService(SberOAuthClient sberOAuthClient, GigaChatClient gigaChatClient, GigaChatProperties properties) {
        this.sberOAuthClient = sberOAuthClient;
        this.gigaChatClient = gigaChatClient;
        this.properties = properties;

    }

    public OAuthResponse requestAccessToken() {
        Map<String, Object> form = new HashMap<>();
        form.put("scope", "GIGACHAT_API_PERS");
        return sberOAuthClient.getAccessToken(
                UUID.randomUUID().toString(), "Basic " + properties.auth(), form).getBody();
    }

    public void isTokenValid(long time) {
        if (Instant.now().toEpochMilli() >= time) {
            OAuthResponse oAuthResponse = requestAccessToken();
            TOKEN_VALIDITY_TIME = Long.parseLong(oAuthResponse.expires_at());
            TOKEN = oAuthResponse.access_token();
            log.info("Токен обновлен.");
        }
        log.info("Токен валидный.");
    }

    public String getChatCompletion(String prompt) {
        // Проверяем валидность токена
        isTokenValid(TOKEN_VALIDITY_TIME);

        // Формируем запрос
        ChatCompletionRequest request = new ChatCompletionRequest(
                "GigaChat-Pro",
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
}