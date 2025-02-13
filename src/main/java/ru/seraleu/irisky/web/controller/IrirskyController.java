package ru.seraleu.irisky.web.controller;

import org.apache.hc.core5.http.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/irisky")
public class IrirskyController {

    @PostMapping(value = "/hello")
    public ResponseEntity<String> hello(@RequestBody String json) {
        try {
            System.out.println("REQUEST: " + LocalDateTime.now() + " MESSAGE: " + json);
            return ResponseEntity.status(HttpStatus.OK).body("{\"response\": \"Расскажи шутку про коня\"}");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
