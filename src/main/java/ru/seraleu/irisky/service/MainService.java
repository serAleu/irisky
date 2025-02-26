package ru.seraleu.irisky.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import ru.seraleu.irisky.web.dto.pprb.phone.CreditHistIdentifier;

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

    public String saveCreditHistProcessingAgentEntityStartCalculating(String json) {
        JsonObject jsonObject = (JsonObject) JsonParser.parseString(json);
        CreditHistProcessingAgentEntity entity = new CreditHistProcessingAgentEntity()
                .setIdentifier(StringUtils.normalizeSpace(jsonObject.get("request").getAsJsonArray().get(0).getAsJsonObject().get("identifier").toString()).replaceAll("\\r\\n|\\r|\\n|\"", ""))
                .setEpkId(3333L)
                .setProcessingJson(StringUtils.normalizeSpace(jsonObject.get("request").getAsJsonArray().get(1).toString()).replaceAll("\\r\\n|\\r|\\n|", ""))
                .setStatus(Status.RECEIVED)
                .setStartDtm(LocalDateTime.now());
        dataService.saveCreditHistProcessingAgentEntity(entity);
        return entity.toString();

    }

    public void saveCreditHistProcessingAgentEntityFinishCalculating(String json) {
        JsonObject jsonObject = (JsonObject) JsonParser.parseString(json);
        String genuuid = jsonObject.get("request").getAsJsonArray().get(0).getAsJsonObject().get("genuuid").toString();
        String result = jsonObject.get("request").getAsJsonArray().get(1).getAsJsonObject().get("gredhistreport").toString();
        CreditHistProcessingAgentEntity entity = dataService.getCreditHistProcessingAgentEntityByGenuuid(genuuid);
        if(entity != null) {
            entity.setResult(result)
                    .setStatus(Status.SUCCESS)
                    .setFinishDtm(LocalDateTime.now());
            dataService.saveCreditHistProcessingAgentEntity(entity);
        } else {
            log.info("Cannot find entity by genuuid = " + genuuid);
        }
    }

    public ResponseEntity<CreditHistIdentifier> generateIdentifier() {
        Random random = new Random();
//        StringBuilder identifier = new StringBuilder("+79");
        StringBuilder identifier = new StringBuilder("k111029");
        for (int i = 0; i < 9; i++) {
            identifier.append((random.nextInt(10)));
        }
        log.info("Phone number: {}", identifier);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new CreditHistIdentifier(identifier.toString()));
    }
}
