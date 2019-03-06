package com.paycoinq.platform.stocks.exception;

/**
 * Exception class for Stocks Not Found
 * 
 * @author bkotharu
 *
 */
public class StockNotFoundException extends Exception {

	private static final long serialVersionUID = 5381543596079987682L;

	public StockNotFoundException(String message) {
		super(message);
	}

}
