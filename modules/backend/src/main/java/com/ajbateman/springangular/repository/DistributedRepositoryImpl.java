package com.ajbateman.springangular.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class DistributedRepositoryImpl<ENTITY> extends SimpleJpaRepository<ENTITY, Integer> implements DistributedRepository<ENTITY>, JpaSpecificationExecutor<ENTITY> {

    public DistributedRepositoryImpl(final JpaEntityInformation<ENTITY, Integer> entityInformation, final EntityManager em) {
        super(entityInformation, em);
    }
}
