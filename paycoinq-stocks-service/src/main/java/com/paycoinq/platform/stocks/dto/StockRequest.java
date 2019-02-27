package com.paycoinq.platform.stocks.dto;

import javax.validation.constraints.NotNull;

public class StockRequest {

	@NotNull(message = "Stock Name is required.")
	private String name;

	@NotNull(message = "Stock Code is required.")
	private String code;

	@NotNull(message = "Stock Price is required.")
	private Double currentPrice;

	@NotNull(message = "Stock Currency Code is required.")
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

}
