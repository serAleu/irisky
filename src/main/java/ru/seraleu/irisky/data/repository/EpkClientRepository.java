package ru.seraleu.irisky.data.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.seraleu.irisky.data.BaseJpaRepository;
import ru.seraleu.irisky.data.entity.EpkClientEntity;

@Repository
public interface EpkClientRepository extends BaseJpaRepository<EpkClientEntity> {

    EpkClientEntity findByPhoneNum(@Param("phoneNum") String phoneNumber);
}
