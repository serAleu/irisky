package ru.seraleu.irisky.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
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
    @Column(name = "phone_num")
    private String phoneNum;
    @Column(name = "agreement_provided")
    private Boolean agreementProvided;
    @Column(name = "full_name")
    private String fullName;
}
