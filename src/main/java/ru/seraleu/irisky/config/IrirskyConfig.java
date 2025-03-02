package ru.seraleu.irisky.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.seraleu.irisky.data.repository.EpkClientRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class IrirskyConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public List<String> identifiers(@Autowired EpkClientRepository epkClientRepository) {
        return epkClientRepository.getAllIdentifiers();
    }

    @Bean
    public List<String> candies() {
        List<String> candies = new ArrayList<>();
        candies.add("Нет слов, ты супер!");
        try (BufferedReader reader = new BufferedReader(new FileReader("/src/main/resources/static/candies.txt"))) {
            while (reader.ready()){
                candies.add(reader.readLine());
            }
        } catch (IOException e) {
            log.error("Candies aren't available ;( ");
        }
        return candies;
    }
}
