package com.paycoinq.platform.stocks.dto;

public class ErrorResponse {

	private String errorCode;

	private String errorMessage;

	public ErrorResponse(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
