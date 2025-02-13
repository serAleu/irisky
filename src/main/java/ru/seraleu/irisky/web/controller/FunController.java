package ru.seraleu.irisky.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping(path = "/get")
@RequiredArgsConstructor
public class FunController {

    @GetMapping(value = "/fun")
    public ResponseEntity<String> getFun() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("Hi, dude!");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/high")
    public RedirectView getHigh() {
        return new RedirectView("https://zoomquilt.org/");
    }
}
