package ru.seraleu.irisky.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.seraleu.irisky.data.entity.CreditHistProcessingAgentEntity;
import ru.seraleu.irisky.data.entity.ProcessingResultValidationAgentEntity;
import ru.seraleu.irisky.enums.Status;
import ru.seraleu.irisky.web.dto.pprb.identifier.CreditHistIdentifier;

import java.time.LocalDateTime;
import java.util.Random;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {

    private final DataService dataService;
    private final ObjectMapper mapper;
    private final CreditHistoryPIValidateService creditHistoryPIValidateService;

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
        creditHistoryPIValidateService.isPiInPprbResponseValid(entity);
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
        StringBuilder identifier = new StringBuilder("k111029");
        for (int i = 0; i < 9; i++) {
            identifier.append((random.nextInt(10)));
        }
        log.info("Credit history identifier: {}", identifier);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new CreditHistIdentifier(identifier.toString()));
    }
}
