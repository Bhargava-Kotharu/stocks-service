package com.paycoinq.platform.stocks.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.paycoinq.platform.stocks.StocksApplication;
import com.paycoinq.platform.stocks.dto.StockRequest;
import com.paycoinq.platform.stocks.dto.StocksDTO;
import com.paycoinq.platform.stocks.exception.StockNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { StocksApplication.class })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StocksControllerTest {

	@Autowired
	private StocksController stocksController;

	@Test
	public void testGetStocks() {
		int page = 0;
		int pageSize = 10;
		ResponseEntity<List<StocksDTO>> response = stocksController.getStocks(page, pageSize);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(10, response.getBody().size());
	}

	@Test
	public void testGetStocksWithDifferentPageSize() {
		int page = 0;
		int pageSize = 2;
		ResponseEntity<List<StocksDTO>> response = stocksController.getStocks(page, pageSize);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(2, response.getBody().size());
	}

	@Test
	public void testGetStock() throws StockNotFoundException {
		long stockId = 1;
		ResponseEntity<StocksDTO> response = stocksController.getStock(stockId);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertNotNull(response.getBody());
		assertEquals(new Long(1), response.getBody().getId());
	}

	@Test(expected = StockNotFoundException.class)
	public void testGetStockForException() throws StockNotFoundException {
		long stockId = 122;
		ResponseEntity<StocksDTO> response = stocksController.getStock(stockId);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertNotNull(response.getBody());
		assertEquals(new Long(1), response.getBody().getId());
	}

	@Test
	public void testUpdateStock() throws StockNotFoundException {
		long stockId = 1;
		StockRequest request = new StockRequest();
		request.setCode("XYZ");
		request.setCurrencyCode("EUR");
		request.setCurrentPrice((double) 123);
		request.setName("XYZ Stocks");
		ResponseEntity<StocksDTO> response = stocksController.updateStock(stockId, request);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().getCode(), "XYZ");
	}

	@Test(expected = StockNotFoundException.class)
	public void testUpdateStockForException() throws StockNotFoundException {
		long stockId = 123;
		StockRequest request = new StockRequest();
		request.setCode("XYZ");
		request.setCurrencyCode("EUR");
		request.setCurrentPrice((double) 123);
		request.setName("XYZ Stocks");
		ResponseEntity<StocksDTO> response = stocksController.updateStock(stockId, request);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().getCode(), "XYZ");
	}

	@Test
	public void testCreateStock() throws StockNotFoundException {
		StockRequest request = new StockRequest();
		request.setCode("XYZ");
		request.setCurrencyCode("EUR");
		request.setCurrentPrice((double) 123);
		request.setName("XYZ Stocks");
		ResponseEntity<StocksDTO> response = stocksController.createStock(request);
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
		assertEquals(response.getBody().getCode(), "XYZ");

		// Assert Size to check if Stock is created by calling getStocks
		int page = 0;
		int pageSize = 100;
		ResponseEntity<List<StocksDTO>> getStockResponse = stocksController.getStocks(page, pageSize);
		assertEquals(getStockResponse.getStatusCode(), HttpStatus.OK);
		assertEquals(11, getStockResponse.getBody().size());

	}

	@Test
	public void testDeleteStock() throws StockNotFoundException {

		ResponseEntity<?> response = stocksController.deleteStock((long) 8);
		assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);

		// Assert Size to check if Stock is deleted by calling getStocks
		int page = 0;
		int pageSize = 100;
		ResponseEntity<List<StocksDTO>> getStockResponse = stocksController.getStocks(page, pageSize);
		assertEquals(getStockResponse.getStatusCode(), HttpStatus.OK);
		assertEquals(9, getStockResponse.getBody().size());

	}

}
