package ru.seraleu.irisky.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.seraleu.irisky.data.entity.CreditHistProcessingAgentEntity;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreditHistoryPIValidateService {

    public void isPiInPprbResponseValid(CreditHistProcessingAgentEntity entity) {
        entity.setPiIsValid(true);
        log.info("Credit history is valid. genuuid = {}", entity.getGenuuid());
    }
}
