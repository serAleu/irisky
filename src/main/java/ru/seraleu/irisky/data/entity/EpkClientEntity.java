package ru.seraleu.irisky.data.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.seraleu.irisky.data.BaseJpaEntity;

@Getter
@Setter
@Accessors(chain = true)
@RequiredArgsConstructor
@Entity
@Table(schema = "i_risky", name = "epk_client")
public class EpkClientEntity extends BaseJpaEntity {

    @Column(name = "epk_id")
    private Long epkId;
    @Column(name = "identifier")
    private String identifier;
    @Column(name = "agreement_provided")
    private Boolean agreementProvided;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "report_credit_history")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode reportCreditHistory;
}
