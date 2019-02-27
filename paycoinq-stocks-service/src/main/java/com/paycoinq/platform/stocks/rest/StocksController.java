package com.paycoinq.platform.stocks.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@RestController
@RequestMapping("/api/v1/stocks")
public class StocksController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StocksController.class);

	@Autowired
	private StocksService stocksService;

	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<StocksDTO>> getStocks(
			@RequestParam(required = false, name = "page", defaultValue = "0") int page,
			@RequestParam(required = false, name = "pageSize", defaultValue = "10") int pageSize) {
		LOGGER.info("Received request to get all the stocks with params page={} | pageSize={}", page, pageSize);
		return ResponseEntity.ok(stocksService.getStocks(page, pageSize));
	}

	@GetMapping("/{stockId}")
	public ResponseEntity<StocksDTO> getStock(@PathVariable(required = true, name = "stockId") Long stockId) {
		return ResponseEntity.ok(stocksService.getStockById(stockId));
	}

	@PutMapping("/{stockId}")
	public StocksDTO updateStock(@PathVariable(required = true, name = "stockId") Long stockId,
			@Valid @RequestBody StockRequest stockRequest) throws StockNotFoundException {
		return stocksService.updateStock(stockId, stockRequest);
	}

	@PostMapping
	public StocksDTO createStock(@Valid @RequestBody StockRequest stockRequest) {
		return stocksService.createStock(stockRequest);
	}
}
