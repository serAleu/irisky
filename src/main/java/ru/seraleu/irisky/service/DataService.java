package ru.seraleu.irisky.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.seraleu.irisky.data.entity.CreditHistProcessingAgentEntity;
import ru.seraleu.irisky.data.entity.EpkClientEntity;
import ru.seraleu.irisky.data.entity.ProcessingResultValidationAgentEntity;
import ru.seraleu.irisky.data.repository.CreditHistProcessingAgentRepository;
import ru.seraleu.irisky.data.repository.EpkClientRepository;
import ru.seraleu.irisky.data.repository.ProcessingResultValidationAgentRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataService {

    private final CreditHistProcessingAgentRepository creditHistProcessingAgentRepository;
    private final EpkClientRepository epkClientRepository;
    private final ProcessingResultValidationAgentRepository processingResultValidationAgentRepository;

    public void saveCreditHistProcessingAgentEntity(CreditHistProcessingAgentEntity entity) {
        creditHistProcessingAgentRepository.save(entity);
        log.info("DataService: successful saving CreditHistProcessingAgentEntity.");
    }

    public CreditHistProcessingAgentEntity getCreditHistProcessingAgentEntityById(String uuid) {
        return creditHistProcessingAgentRepository.getReferenceById(uuid);
    }

    public void saveEpkClientJpaEntity(EpkClientEntity entity) {
        epkClientRepository.save(entity);
        log.info("DataService: successful saving EpkClientEntity.");
    }

    public void saveProcessingResultValidationAgentEntity(ProcessingResultValidationAgentEntity entity) {
        processingResultValidationAgentRepository.save(entity);
        log.info("DataService: successful saving ProcessingResultValidationAgentEntity.");
    }
}