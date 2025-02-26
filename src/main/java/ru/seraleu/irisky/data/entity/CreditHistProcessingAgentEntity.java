package ru.seraleu.irisky.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;
import ru.seraleu.irisky.enums.Status;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@RequiredArgsConstructor
@Entity
@Table(schema = "i_risky", name = "credit_hist_processing_agent")
public class CreditHistProcessingAgentEntity {

    @Id
    @Column(name = "genuuid")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String genuuid;
    @Column(name = "epk_id")
    private Long epkId;
    @Column(name = "credit_history_identifier")
    private String identifier;
    @Column(name = "processing_json")
    private String processingJson;
    @Column(name = "result")
    private String result;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "start_dtm")
    private LocalDateTime startDtm;
    @Column(name = "finish_dtm")
    private LocalDateTime finishDtm;
    @Column(name = "error_details")
    private String errorDetails;

    @Override
    public String toString() {
        return "{" +
                "\"genuuid\":\"" + genuuid +
                "\"}";
    }
}
