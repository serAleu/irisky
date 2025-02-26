package ru.seraleu.irisky.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.seraleu.irisky.data.repository.EpkClientRepository;

import java.util.List;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class IrirskyConfig {

    private final EpkClientRepository epkClientRepository;

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    @Bean
    @PostConstruct
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public List<String> identifiers() {
        return epkClientRepository.getAllIdentifiers();
    }
}
