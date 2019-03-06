package com.paycoinq.platform.stocks.dto;

import javax.validation.constraints.NotNull;

import com.paycoinq.platform.stocks.constants.ApplicationConstants;

/**
 * Request object for creation and updation of Stocks
 * 
 * @author bkotharu
 *
 */
public class StockRequest {

	@NotNull(message = ApplicationConstants.STOCK_NAME_ERROR_MESG)
	private String name;

	@NotNull(message = ApplicationConstants.STOCK_CODE_ERROR_MESG)
	private String code;

	@NotNull(message = ApplicationConstants.STOCK_CURRENT_PRICE_ERROR_MESG)
	private Double currentPrice;

	@NotNull(message = ApplicationConstants.STOCK_CURRENCY_CODE_ERROR_MESG)
	private String currencyCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "StockRequest [name=" + name + ", code=" + code + ", currentPrice=" + currentPrice + ", currencyCode="
				+ currencyCode + "]";
	}

}
