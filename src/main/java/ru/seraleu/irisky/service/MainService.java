package ru.seraleu.irisky.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.seraleu.irisky.data.entity.CreditHistProcessingAgentEntity;
import ru.seraleu.irisky.data.entity.EpkClientEntity;
import ru.seraleu.irisky.data.entity.ProcessingResultValidationAgentEntity;
import ru.seraleu.irisky.enums.Status;
import ru.seraleu.irisky.utils.PprbResponseMockGenerator;
import ru.seraleu.irisky.web.dto.pprb.phone.PhoneNumberResponse;

import java.time.LocalDateTime;
import java.util.Random;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {

    private final PprbResponseMockGenerator mockGenerator;
    private final DataService dataService;
    //    private final EpkClientJpaRepository epkClientJpaRepository;
    private final ObjectMapper mapper;

    public ResponseEntity<String> processRequest(String request) {
        ResponseEntity<String> response = null;
        EpkClientEntity epkClientEntity = new EpkClientEntity();
        try {
            JsonNode node = mapper.readTree(request);
            if (mapper.readTree(request).has("phoneNumber")) {
                String creditHistory = mockGenerator.getRandomPprbResponseMosk(node.get("phoneNumber").toString()).toString();
//                epkClientEntity.setStatus(SUCCESS).setResponse(creditHistory).setRequest(node.toString());
                response = ResponseEntity.status(HttpStatus.OK).body(creditHistory);
            } else {
//                epkClientEntity.setStatus(BAD_REQUEST);
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mockGenerator.getBadRequestMessage());
            }
        } catch (Exception e) {
            String errMsg = "Error while process request from giga. " + getStackTrace(e);
//            epkClientEntity.setStatus(Status.ERROR).setErrorDetails(errMsg);
            log.error(errMsg);
        }
//        epkClientEntity.setAddedAt(LocalDateTime.now());
//        epkClientJpaRepository.save(epkClientEntity);
        return response;
    }

    public void saveProcessingResultValidationEntity(String json) throws Exception {
        JsonNode jsonNode = mapper.readTree(json);
        ProcessingResultValidationAgentEntity entity = new ProcessingResultValidationAgentEntity()
                .setCreditHistProcessingAgentUuid(jsonNode.get("uuid").asText())
                .setStatus(Status.defineStatus(jsonNode.get("status").asText()))
                .setResult(jsonNode.get("result").asText())
                .setAddedAt(LocalDateTime.now());
        dataService.saveProcessingResultValidationAgentEntity(entity);
    }

    public void saveProcessingResultValidationEntityError(Exception e) {
        ProcessingResultValidationAgentEntity entity = new ProcessingResultValidationAgentEntity()
                .setStatus(Status.ERROR)
                .setAddedAt(LocalDateTime.now())
                .setErrorDetails(getStackTrace(e));
        dataService.saveProcessingResultValidationAgentEntity(entity);
    }

    public String saveCreditHistProcessingAgentEntityStartCalculating(String json) throws Exception {
        JsonNode jsonNode = mapper.readTree(json);
        CreditHistProcessingAgentEntity entity = new CreditHistProcessingAgentEntity()
                .setEpkId(jsonNode.get("epk_id").asLong())
                .setPhoneNum(jsonNode.get("phone_num").asText())
                .setProcessingJson(StringUtils.normalizeSpace(json).replaceAll("\\r\\n|\\r|\\n", ""))
                .setStatus(Status.RECEIVED)
                .setStartDtm(LocalDateTime.now());
        dataService.saveCreditHistProcessingAgentEntity(entity);
        return entity.toString();

    }

    public void saveCreditHistProcessingAgentEntityFinishCalculating(String json) throws Exception {
        JsonNode jsonNode = mapper.readTree(json);
        String uuid = jsonNode.get("uuid").asText();
        CreditHistProcessingAgentEntity entity = dataService.getCreditHistProcessingAgentEntityById(uuid);
        if(entity != null) {
            entity.setResult(StringUtils.normalizeSpace(jsonNode.get("result").asText()).replaceAll("\\r\\n|\\r|\\n", ""))
                    .setStatus(Status.SUCCESS)
                    .setFinishDtm(LocalDateTime.now());
            dataService.saveCreditHistProcessingAgentEntity(entity);
        } else {
            log.info("Cannot find entity by uuid = " + uuid);
        }
    }

    public void saveCreditHistProcessingAgentEntityError(Exception e) {
        dataService.saveCreditHistProcessingAgentEntity(new CreditHistProcessingAgentEntity()
                .setStatus(Status.ERROR)
                .setErrorDetails(getStackTrace(e)));
    }

    public ResponseEntity<PhoneNumberResponse> generatePhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("+79");
        for (int i = 0; i < 9; i++) {
            phoneNumber.append((random.nextInt(10)));
        }
        log.info("Phone number: " + phoneNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(PhoneNumberResponse
                        .builder()
                        .phoneNumber(phoneNumber.toString())
                        .build());
    }
}
