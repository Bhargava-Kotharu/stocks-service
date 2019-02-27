package com.paycoinq.platform.stocks.service;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	public List<StocksDTO> getStocks(int page, int pageSize) {
		PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.Direction.ASC, "id");
		Page<StocksEntity> pageResult = stocksRepository.findAll(pageRequest);
		return stocksMapper.mapAsList((List<StocksEntity>) pageResult.getContent(), StocksDTO.class);
	}

	@Override
	public StocksDTO getStockById(Long stockId) {
		Optional<StocksEntity> stocksEntity = stocksRepository.findById(stockId);
		return stocksMapper.map(stocksEntity.get(), StocksDTO.class);
	}

	@Override
	public StocksDTO createStock(StockRequest stockRequest) {
		StocksEntity entity = stocksMapper.map(stockRequest, StocksEntity.class);
		return stocksMapper.map(stocksRepository.save(entity), StocksDTO.class);
	}

	@Override
	public StocksDTO updateStock(Long stockId, StockRequest stockRequest) throws StockNotFoundException {
		Optional<StocksEntity> optional = stocksRepository.findById(stockId);

		if (!optional.isPresent()) {
			throw new StockNotFoundException(String.format("Stock with id %d not found.", stockId));
		}

		StocksEntity stocksEntity = optional.get();
		stocksEntity.setCode(stockRequest.getCode());
		stocksEntity.setName(stockRequest.getName());
		stocksEntity.setCurrentPrice(stockRequest.getCurrentPrice());
		stocksEntity.setCurrencyCode(stockRequest.getCurrencyCode());

		return stocksMapper.map(stocksRepository.save(stocksEntity), StocksDTO.class);

	}

}
