package com.paycoinq.platform.stocks.model.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.paycoinq.platform.stocks.model.entity.StocksEntity;

@Repository
public interface StocksRepository extends PagingAndSortingRepository<StocksEntity, Long> {

	//public Optional<StocksEntity> findById(Long id);
}
