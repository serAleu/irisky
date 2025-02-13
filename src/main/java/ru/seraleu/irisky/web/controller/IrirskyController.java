package ru.seraleu.irisky.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.seraleu.irisky.service.MainService;

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
}
