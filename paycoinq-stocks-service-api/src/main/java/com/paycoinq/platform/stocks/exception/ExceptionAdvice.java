package com.paycoinq.platform.stocks.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.paycoinq.platform.stocks.dto.ErrorResponse;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

	@ExceptionHandler(value = { StockNotFoundException.class })
	protected ResponseEntity<Object> handleNotFound(StockNotFoundException ex, WebRequest request) {
		LOGGER.error("Error occured while processing request", ex);
		return handleExceptionInternal(ex, new ErrorResponse("PAY-STOCK-404-NOT-FOUND", ex.getMessage()),
				new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

}
