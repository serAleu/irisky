package ru.seraleu.irisky.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.seraleu.irisky.data.entity.CreditHistoryRequestEntity;
import ru.seraleu.irisky.data.repository.CreditHistoryRequestJpaRepository;
import ru.seraleu.irisky.enums.Status;
import ru.seraleu.irisky.utils.PprbResponseMockGenerator;
import ru.seraleu.irisky.web.dto.pprb.phone.PhoneNumberResponse;

import java.time.LocalDateTime;
import java.util.Random;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;
import static ru.seraleu.irisky.enums.Status.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {

    private final PprbResponseMockGenerator mockGenerator;
    private final CreditHistoryRequestJpaRepository creditHistoryRequestJpaRepository;
    private final ObjectMapper mapper;

    public ResponseEntity<String> processRequest(String request) {
        ResponseEntity<String> response = null;
        CreditHistoryRequestEntity creditHistoryRequestEntity = new CreditHistoryRequestEntity();
        try {
            JsonNode node = mapper.readTree(request);
            if (mapper.readTree(request).has("phoneNumber")) {
                String creditHistory = mockGenerator.getRandomPprbResponseMosk(node.get("phoneNumber").toString()).toString();
                creditHistoryRequestEntity.setStatus(SUCCESS).setResponse(creditHistory).setRequest(node.toString());
                response = ResponseEntity.status(HttpStatus.OK).body(creditHistory);
            } else {
                creditHistoryRequestEntity.setStatus(BAD_REQUEST);
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mockGenerator.getBadRequestMessage());
            }
        } catch (Exception e) {
            String errMsg = "Error while process request from giga. " + getStackTrace(e);
            creditHistoryRequestEntity.setStatus(Status.ERROR).setErrorDetails(errMsg);
            log.error(errMsg);
        }
        creditHistoryRequestEntity.setAddedAt(LocalDateTime.now());
        creditHistoryRequestJpaRepository.save(creditHistoryRequestEntity);
        return response;
    }

    public ResponseEntity<PhoneNumberResponse> generatePhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("+79");
        for (int i = 0; i < 9; i++) {
            phoneNumber.append((random.nextInt(10)));
        }
        log.info("Phone number: " + phoneNumber);
        return  ResponseEntity.status(HttpStatus.OK)
                .body(PhoneNumberResponse
                        .builder()
                        .phoneNumber(phoneNumber.toString())
                        .build());
    }
}
