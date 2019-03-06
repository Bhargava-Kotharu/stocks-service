package com.paycoinq.platform.stocks.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.paycoinq.platform.stocks.model.entity.StocksEntity;

/**
 * Repository for StocksEntity
 * 
 * @author bkotharu
 *
 */
@Repository
public interface StocksRepository extends PagingAndSortingRepository<StocksEntity, Long> {

}
