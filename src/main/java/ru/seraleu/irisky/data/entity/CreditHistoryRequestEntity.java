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
@Table(schema = "giga", name = "credit_history_request")
public class CreditHistoryRequestEntity extends BaseJpaEntity {

    @Column(name = "added_at")
    private LocalDateTime addedAt;
    @Column(name = "request")
    private String request;
    @Column(name = "response")
    private String response;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "error_details")
    private String errorDetails;
}
