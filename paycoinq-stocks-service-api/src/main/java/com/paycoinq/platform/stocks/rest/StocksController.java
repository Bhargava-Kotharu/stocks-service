package com.paycoinq.platform.stocks.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paycoinq.platform.stocks.dto.StockRequest;
import com.paycoinq.platform.stocks.dto.StocksDTO;
import com.paycoinq.platform.stocks.exception.StockNotFoundException;
import com.paycoinq.platform.stocks.service.StocksService;

/**
 * REST endpoints for Stocks API
 * 
 * @author bkotharu
 *
 */
@RestController
@RequestMapping("/api/v1/stocks")
@CrossOrigin(origins = "http://localhost:4200")
public class StocksController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StocksController.class);

	@Autowired
	private StocksService stocksService;

	/**
	 * Get Stocks API
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<StocksDTO>> getStocks(
			@RequestParam(required = false, name = "page", defaultValue = "0") int page,
			@RequestParam(required = false, name = "pageSize", defaultValue = "10") int pageSize) {
		LOGGER.info("Received request to get all the stocks with params page={} | pageSize={}", page, pageSize);
		return ResponseEntity.ok(stocksService.getStocks(page, pageSize));
	}

	/**
	 * Get Stock By ID
	 * 
	 * @param stockId
	 * @return
	 * @throws StockNotFoundException
	 */
	@GetMapping("/{stockId}")
	public ResponseEntity<StocksDTO> getStock(@PathVariable(required = true, name = "stockId") Long stockId)
			throws StockNotFoundException {
		LOGGER.info("Received request to get stock by stockId={}", stockId);
		StocksDTO dto = stocksService.getStockById(stockId);
		return ResponseEntity.ok(dto);
	}

	/**
	 * Update Stock API
	 * 
	 * @param stockId
	 * @param stockRequest
	 * @return
	 * @throws StockNotFoundException
	 */
	@PutMapping("/{stockId}")
	public ResponseEntity<StocksDTO> updateStock(@PathVariable(required = true, name = "stockId") Long stockId,
			@Valid @RequestBody StockRequest stockRequest) throws StockNotFoundException {
		LOGGER.info("Received request to update stock by stockId={} | StockRequest={}", stockId, stockRequest);
		StocksDTO dto = stocksService.updateStock(stockId, stockRequest);
		return ResponseEntity.ok(dto);
	}

	/**
	 * Create Stock API
	 * 
	 * @param stockRequest
	 * @return
	 */
	@PostMapping
	public ResponseEntity<StocksDTO> createStock(@Valid @RequestBody StockRequest stockRequest) {
		LOGGER.info("Received request to create stock | StockRequest={}", stockRequest);
		StocksDTO dto = stocksService.createStock(stockRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	/**
	 * Delete Stock API
	 * 
	 * @param stockId
	 * @return
	 * @throws StockNotFoundException
	 */
	@DeleteMapping("/{stockId}")
	public ResponseEntity<?> deleteStock(@PathVariable(required = true, name = "stockId") Long stockId)
			throws StockNotFoundException {
		LOGGER.info("Received request to delete stock | stockId={}", stockId);
		boolean result = stocksService.deleteStock(stockId);
		return result ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
	}
}
