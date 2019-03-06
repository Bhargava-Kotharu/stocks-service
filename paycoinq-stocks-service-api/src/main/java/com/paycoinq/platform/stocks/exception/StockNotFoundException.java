package com.paycoinq.platform.stocks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for Stocks Not Found
 * 
 * @author bkotharu
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StockNotFoundException extends Exception {

	private static final long serialVersionUID = 5381543596079987682L;

	public StockNotFoundException(String message) {
		super(message);
	}

}
