package ru.seraleu.irisky.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.seraleu.irisky.data.BaseJpaEntity;
import ru.seraleu.irisky.enums.Status;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@RequiredArgsConstructor
@Entity
@Table(schema = "i_risky", name = "processing_result_validation_agent")
public class ProcessingResultValidationAgentEntity extends BaseJpaEntity {

    @Column(name = "credit_hist_processing_agent_uuid")
    private String creditHistProcessingAgentUuid;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "result")
    private String result;
    @Column(name = "added_at")
    private LocalDateTime addedAt;
    @Column(name = "error_details")
    private String errorDetails;
}
