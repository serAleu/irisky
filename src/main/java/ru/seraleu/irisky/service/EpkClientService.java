package ru.seraleu.irisky.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.seraleu.irisky.data.entity.EpkClientEntity;
import ru.seraleu.irisky.data.repository.EpkClientRepository;
import ru.seraleu.irisky.web.dto.pprb.Root;
import ru.seraleu.irisky.web.dto.pprb.phone.PhoneNumberResponse;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class EpkClientService {
    private final ObjectMapper objectMapper;
    private final EpkClientRepository epkClientRepository;

    public ResponseEntity<Root> getRootByPhoneNumber(String phoneNumber) {
        try {
            JsonNode reportCreditHistory = epkClientRepository.findByPhoneNum(phoneNumber).getReportCreditHistory();
            Root root = objectMapper.readValue(reportCreditHistory.asText(), Root.class);
            return ResponseEntity.status(HttpStatus.OK).body(root);
        } catch (Exception e) {
            log.error("Ошибка при обращение к бд. Не удалось получить КИ.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<PhoneNumberResponse> getRandomPhoneNumber() {
        Random random = new Random();
        List<EpkClientEntity> epkClientEntity = epkClientRepository.findAll();
        int randomIndex = random.nextInt(epkClientEntity.size());
        PhoneNumberResponse phoneNumberResponse =
                new PhoneNumberResponse(epkClientEntity.get(randomIndex).getPhoneNum());
        return ResponseEntity.status(HttpStatus.OK)
                .body(phoneNumberResponse);
    }
}
