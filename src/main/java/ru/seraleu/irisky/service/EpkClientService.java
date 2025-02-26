package ru.seraleu.irisky.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.seraleu.irisky.data.repository.EpkClientRepository;
import ru.seraleu.irisky.web.dto.pprb.Root;
import ru.seraleu.irisky.web.dto.pprb.phone.CreditHistIdentifier;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class EpkClientService {

    private final ObjectMapper objectMapper;
    private final EpkClientRepository epkClientRepository;
    private final List<String> identifiers;

    public ResponseEntity<Root> getRootByCreditHistIdentifier(String identifier) {
        try {
            JsonNode reportCreditHistory = epkClientRepository.findByIdentifier(identifier).getReportCreditHistory();
            Root root = objectMapper.readValue(reportCreditHistory.asText(), Root.class);
            //метод валидации КИ на предмет левой персоналки в кредитах
            return ResponseEntity.status(HttpStatus.OK).body(root);
        } catch (Exception e) {
            log.error("Ошибка при обращение к бд. Не удалось получить КИ.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<CreditHistIdentifier> getRandomCreditHistIdentifier() {
        return ResponseEntity.status(HttpStatus.OK).body(new CreditHistIdentifier(identifiers.get(new Random().nextInt(identifiers.size()))));
    }
}
