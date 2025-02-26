package ru.seraleu.irisky.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.seraleu.irisky.data.BaseJpaRepository;
import ru.seraleu.irisky.data.entity.EpkClientEntity;

import java.util.List;

@Repository
public interface EpkClientRepository extends BaseJpaRepository<EpkClientEntity> {

    EpkClientEntity findByIdentifier(@Param("identifier") String identifier);

    @Query(value = "select credit_history_identifier from i_risky.epk_client", nativeQuery = true)
    List<String> getAllIdentifiers();
}
