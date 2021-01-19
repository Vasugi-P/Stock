package com.ing.stock.service;

import java.io.IOException;

import com.ing.stock.dto.ResponseStockDto;

public interface StockService {

	ResponseStockDto getStocks(Long stockId) throws IOException;

}
