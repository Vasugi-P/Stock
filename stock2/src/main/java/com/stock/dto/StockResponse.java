package com.stock.dto;

import java.util.List;

public class StockResponse {
	
	private String statusCode;
	private List<StockDto> stockDto;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public List<StockDto> getStockDto() {
		return stockDto;
	}
	public void setStockDto(List<StockDto> stockDto) {
		this.stockDto = stockDto;
	}
	
	

}
