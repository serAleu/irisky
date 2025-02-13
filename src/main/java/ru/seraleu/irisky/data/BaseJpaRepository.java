package ru.seraleu.irisky.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseJpaRepository<T extends BaseJpaEntity> extends JpaRepository<T, Long> {}