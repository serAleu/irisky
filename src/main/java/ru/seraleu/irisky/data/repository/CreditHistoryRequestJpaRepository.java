package ru.seraleu.irisky.data.repository;

import org.springframework.stereotype.Repository;
import ru.seraleu.irisky.data.BaseJpaRepository;
import ru.seraleu.irisky.data.entity.CreditHistoryRequestEntity;

@Repository
public interface CreditHistoryRequestJpaRepository extends BaseJpaRepository<CreditHistoryRequestEntity> {
}
