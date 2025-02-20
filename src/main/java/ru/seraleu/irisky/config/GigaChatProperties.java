package ru.seraleu.irisky.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sber.llm")
public record GigaChatProperties(
        String auth){
}
