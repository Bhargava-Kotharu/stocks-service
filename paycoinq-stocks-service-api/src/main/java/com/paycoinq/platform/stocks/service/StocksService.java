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

	/**
	 * Get All Stocks. This method takes page number and page size as arguments to
	 * filter.
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<StocksDTO> getStocks(int page, int pageSize);

	/**
	 * Get Stock By ID. This method takes stockId as argument and returns StocksDTO
	 * otherwise throws StockNotFoundException
	 * 
	 * @param stockId
	 * @return
	 * @throws StockNotFoundException
	 */
	public StocksDTO getStockById(Long stockId) throws StockNotFoundException;

	/**
	 * Create Stock. This method takes StockRequest as parameter and creates a
	 * stock.
	 * 
	 * @param stockRequest
	 * @return
	 */
	public StocksDTO createStock(StockRequest stockRequest);

	/**
	 * Update Stock. This method takes stockId and StockRequest as parameters and
	 * udpates the stock if stockId is found otherwise throws StockNotFoundException
	 * 
	 * @param stockId
	 * @param stockRequest
	 * @return
	 * @throws StockNotFoundException
	 */
	public StocksDTO updateStock(Long stockId, StockRequest stockRequest) throws StockNotFoundException;

	/**
	 * Delete Stock. This method deletes stock by Id if found, otherwise throws
	 * StockNotFoundException
	 * 
	 * @param stockId
	 * @return
	 * @throws StockNotFoundException
	 */
	public boolean deleteStock(Long stockId) throws StockNotFoundException;
}
