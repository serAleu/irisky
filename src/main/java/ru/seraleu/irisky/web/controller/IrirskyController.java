package ru.seraleu.irisky.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.seraleu.irisky.service.MainService;
import ru.seraleu.irisky.web.dto.pprb.phone.PhoneNumberResponse;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@RestController
@RequestMapping(path = "/credit-hist")
@RequiredArgsConstructor
@Slf4j
public class IrirskyController {

    private final MainService mainService;

    @PostMapping(value = "/save-credit-hist-processing-start", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> saveCreditHistProcessingAgentEntityStartCalculating(@RequestBody String request) {
        log.info("Saving request JSON into credit_hist_processing_agent table. request: " + '\n' + request);
        try {
            String creditHistProcessingEntityPKJson = mainService.saveCreditHistProcessingAgentEntityStartCalculating(request);
            log.info("Primary key for credit_hist_processing_agent table: " + '\n' + creditHistProcessingEntityPKJson);
            return ResponseEntity.status(HttpStatus.OK).body(creditHistProcessingEntityPKJson);
        } catch (Exception e) {
            log.error("Error while saving processing json into credit_hist_processing_agent table. {}", getStackTrace(e));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping(value = "/save-credit-hist-processing-finish", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> saveCreditHistProcessingAgentEntityFinishCalculating(@RequestBody String response) {
        log.info("Saving response JSON into credit_hist_processing_agent table. response: " + '\n' + response);
        try {
            mainService.saveCreditHistProcessingAgentEntityFinishCalculating(response);
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

    @PostMapping(value = "/post", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> getCreditHistoryByPhoneNumber(@RequestBody String request) {
        log.info("Started processing the request. request: " + '\n' + request);
        return mainService.processRequest(request);
    }

    @GetMapping(value = "/get-number", produces = "application/json")
    public ResponseEntity<PhoneNumberResponse> getNumber() {
        log.info("Started processing the generating a phone number.");
        return mainService.generateNumber();
    }

//    @GetMapping(value = "/hello", consumes = "application/json", produces = "application/json")
    @GetMapping(value = "/hello")
    public ResponseEntity<String> getSayHello() {
        log.info("getSayHello: " + "message");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
