package ru.seraleu.irisky.web.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import ru.seraleu.irisky.config.FeignClientConfig;
import ru.seraleu.irisky.web.dto.pprb.giga.rs.OAuthResponse;

import java.util.Map;

@FeignClient(name = "my-client", url = "https://ngw.devices.sberbank.ru:9443/api/v2/oauth", configuration = FeignClientConfig.class)
public interface SberOAuthClient {

    @PostMapping(
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OAuthResponse> getAccessToken(@RequestHeader("RqUID") String rqUID,
                                                 @RequestHeader("Authorization") String auth,
                                                 @RequestBody Map<String, ?> form);
}
