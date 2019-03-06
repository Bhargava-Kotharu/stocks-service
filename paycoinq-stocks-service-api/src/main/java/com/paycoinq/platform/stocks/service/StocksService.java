package com.paycoinq.platform.stocks.service;

import java.util.List;

import com.paycoinq.platform.stocks.dto.StockRequest;
import com.paycoinq.platform.stocks.dto.StocksDTO;
import com.paycoinq.platform.stocks.exception.StockNotFoundException;

/**
 * Service class to handle Stocks CRUD operations
 * 
 * @author bkotharu
 *
 */
public interface StocksService {

	public List<StocksDTO> getStocks(int page, int pageSize);

	public StocksDTO getStockById(Long stockId) throws StockNotFoundException;

	public StocksDTO createStock(StockRequest stockRequest);

	public StocksDTO updateStock(Long stockId, StockRequest stockRequest) throws StockNotFoundException;

	public boolean deleteStock(Long stockId) throws StockNotFoundException;
}
