package com.paycoinq.platform.stocks.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.paycoinq.platform.stocks.dto.StockRequest;
import com.paycoinq.platform.stocks.dto.StocksDTO;
import com.paycoinq.platform.stocks.exception.StockNotFoundException;
import com.paycoinq.platform.stocks.model.entity.StocksEntity;
import com.paycoinq.platform.stocks.model.mapper.StocksMapper;
import com.paycoinq.platform.stocks.model.repository.StocksRepository;

@Service
public class StocksServiceImpl implements StocksService {

	@Autowired
	private StocksRepository stocksRepository;

	@Autowired
	private StocksMapper stocksMapper;

	@Override
	@Transactional
	public List<StocksDTO> getStocks(int page, int pageSize) {
		PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.Direction.ASC, "id");
		Page<StocksEntity> pageResult = stocksRepository.findAll(pageRequest);
		return stocksMapper.mapAsList((List<StocksEntity>) pageResult.getContent(), StocksDTO.class);
	}

	@Override
	public StocksDTO getStockById(Long stockId) throws StockNotFoundException {
		Optional<StocksEntity> optional = stocksRepository.findById(stockId);
		StocksEntity entity = optional
				.orElseThrow(() -> new StockNotFoundException(String.format("Stock with %d is not found.", stockId)));
		return stocksMapper.map(entity, StocksDTO.class);
	}

	@Override
	@Transactional
	public StocksDTO createStock(StockRequest stockRequest) {
		StocksEntity entity = stocksMapper.map(stockRequest, StocksEntity.class);
		return stocksMapper.map(stocksRepository.save(entity), StocksDTO.class);
	}

	@Override
	@Modifying
	@Transactional
	public StocksDTO updateStock(Long stockId, StockRequest stockRequest) throws StockNotFoundException {
		Optional<StocksEntity> optional = stocksRepository.findById(stockId);

		StocksEntity stocksEntity = optional
				.orElseThrow(() -> new StockNotFoundException(String.format("Stock with %d is not found.", stockId)));

		stocksEntity.setCode(stockRequest.getCode());
		stocksEntity.setName(stockRequest.getName());
		stocksEntity.setCurrentPrice(stockRequest.getCurrentPrice());
		stocksEntity.setCurrencyCode(stockRequest.getCurrencyCode());

		return stocksMapper.map(stocksRepository.save(stocksEntity), StocksDTO.class);

	}

	@Override
	@Modifying
	@Transactional
	public boolean deleteStock(Long stockId) throws StockNotFoundException {

		Optional<StocksEntity> optional = stocksRepository.findById(stockId);
		StocksEntity stocksEntity = optional
				.orElseThrow(() -> new StockNotFoundException(String.format("Stock with %d is not found.", stockId)));

		stocksRepository.delete(stocksEntity);
		return true;
	}

}
