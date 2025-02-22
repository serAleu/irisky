package ru.seraleu.irisky.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.seraleu.irisky.data.entity.CreditHistProcessingAgentEntity;

@Repository
public interface CreditHistProcessingAgentRepository extends JpaRepository<CreditHistProcessingAgentEntity, String> {
}
