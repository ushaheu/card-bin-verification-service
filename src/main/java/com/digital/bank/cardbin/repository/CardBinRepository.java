package com.digital.bank.cardbin.repository;

import com.digital.bank.cardbin.entity.CardBinEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ushaheu
 * @date 8/27/20 6:03 PM
 * @project card-bin-verification-service
 */
@Repository
public interface CardBinRepository extends CrudRepository<CardBinEntity, Long> {

    Page<CardBinEntity> findAll(Pageable pageable);
}
