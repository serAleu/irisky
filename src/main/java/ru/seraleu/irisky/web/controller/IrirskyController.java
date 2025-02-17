package ru.seraleu.irisky.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.seraleu.irisky.service.MainService;
import ru.seraleu.irisky.web.dto.pprb.phone.PhoneNumberResponse;

@RestController
@RequestMapping(path = "/credit-hist")
@RequiredArgsConstructor
@Slf4j
public class IrirskyController {

    private final MainService mainService;

    @PostMapping(value = "/post", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> getCreditHistoryByPhoneNumber(@RequestBody String request) {
        log.info("Started processing the request. request: " + '\n' + request);
        return mainService.processRequest(request);
    }

    @GetMapping(value = "/getPhone", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PhoneNumberResponse> getPhoneNumber() {
        log.info("Started processing the generating a phone number.");
        return mainService.generatePhoneNumber();
    }
}
