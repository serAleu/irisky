package ru.seraleu.irisky.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.seraleu.irisky.service.DataService;
import ru.seraleu.irisky.service.EpkClientService;
import ru.seraleu.irisky.service.MainService;
import ru.seraleu.irisky.utils.IriskyUtils;
import ru.seraleu.irisky.web.dto.pprb.GenuuidDTO;
import ru.seraleu.irisky.web.dto.pprb.identifier.CreditHistIdentifier;

import java.util.List;
import java.util.Random;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@RestController
@RequestMapping(path = "/credit-hist")
@RequiredArgsConstructor
@Slf4j

public class IrirskyController {

    private final MainService mainService;
    private final DataService dataService;

    private final EpkClientService epkClientService;
    private final List<String> candies;

    @PostMapping(value = "/save-credit-hist-processing-start", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> saveCreditHistProcessingAgentEntityStartCalculating(@RequestBody String request) {
        log.info("Saving request JSON into credit_hist_processing_agent table. request: " + '\n' + request);
        try {
            String creditHistProcessingEntityPKJson = mainService.saveCreditHistProcessingAgentEntityStartCalculating(request);
            log.info("genuuid for credit_hist_processing_agent table: " + '\n' + creditHistProcessingEntityPKJson);
            return ResponseEntity.status(HttpStatus.OK).body(creditHistProcessingEntityPKJson);
        } catch (Exception e) {
            log.error("Error while saving processing json into credit_hist_processing_agent table. {}", getStackTrace(e));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping(value = "/save-credit-hist-processing-finish", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> saveCreditHistProcessingAgentEntityFinishCalculating(@RequestBody String response) {
        log.info("Saving unvalidated response into credit_hist_processing_agent table. response: " + '\n' + response);
        try {
            mainService.saveCreditHistProcessingAgentEntityFinishCalculating(response);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            log.error("Error while saving validated result into credit_hist_processing_agent table. {}", getStackTrace(e));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping(value = "/save-credit-hist-processing-validation-finish", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> saveCreditHistProcessingAgentEntityValidationFinishedCalculating(@RequestBody String uuid){
        log.info("Saving validation uuid. : " + '\n' + uuid);
        try {
            mainService.saveCreditHistProcessingAgentEntityValidationFinishedCalculating(uuid);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            log.error("Error while saving validated result into credit_hist_processing_agent table. {}", getStackTrace(e));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping(value = "/save-credit-hist-processing-validation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> saveProcessingResultValidationEntity(@RequestBody String response) {
        log.info("Saving response JSON into processing_result_validation_agent table. response: " + '\n' + response);
        try {
            mainService.saveProcessingResultValidationEntity(response);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            mainService.saveProcessingResultValidationEntityError(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/get-number", produces = "application/json")
    public ResponseEntity<CreditHistIdentifier> getRandomCreditHistIdentifier() {
        log.info("Started processing the getting random credit hist identifier.");
        return epkClientService.getRandomCreditHistIdentifier();
    }

    @PostMapping(value = "/get-credit-history", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getCredHistByCreditHistIdentifier(@RequestBody CreditHistIdentifier creditHistIdentifier) {
        log.info("Start processing credit history request. CreditHistIdentifier: " + '\n' + creditHistIdentifier);
        return epkClientService.getRootByCreditHistIdentifier(creditHistIdentifier.getIdentifier());
    }

    @PostMapping(value = "/get-report", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> getReport(@RequestBody GenuuidDTO uuid){
        log.info("Credit report was requested for uuid " + uuid );
        return ResponseEntity.status(HttpStatus.OK)
                .body(IriskyUtils.formatReport(dataService.getCreditHistProcessingAgentEntityByGenuuid(uuid.getGenuuid()).getResult()));

    }

    @GetMapping(value = "/super")
    public String ureSuper() {
        String candy = candies.get(new Random().nextInt(candies.size()));
        log.info("Someone had candy! {}", candy);
        return candy;
    }

    @GetMapping(value = "/health-check")
    public ResponseEntity<String> healthCheck() {
        log.info("Successful health check");
        return ResponseEntity.status(HttpStatus.OK).body("200 OK");
    }
}
