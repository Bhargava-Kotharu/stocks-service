package com.paycoinq.platform.stocks.dto;

/**
 * DTO object
 * 
 * @author bkotharu
 *
 */
public class StocksDTO {

	private Long id;

	private String name;

	private String code;

	private Double currentPrice;

	private String currencyCode;

	private String createdDate;

	private String lastUpdated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "StocksDTO [id=" + id + ", name=" + name + ", code=" + code + ", currentPrice=" + currentPrice
				+ ", currencyCode=" + currencyCode + ", createdDate=" + createdDate + ", lastUpdated=" + lastUpdated
				+ "]";
	}

}
