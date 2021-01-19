package com.stock.service;

import java.util.List;

import com.stock.dto.MyStockdto;
import com.stock.dto.StockDto;
import com.stock.entity.MyStock;
import com.stock.entity.Stock;
import com.stock.exception.SearchStockNotFoundException;
import com.stock.exception.StockIdNotFoundException;
import com.stock.exception.StockNameNotFoundException;
import com.stock.exception.StockNotFoundException;


public interface StockService {
	
	public List<Stock> getAllStock()throws StockNotFoundException;
	
	public List<StockDto> getStocks(String stockName)throws StockNameNotFoundException;
	
	List<MyStockdto>  getMyStock(Long userId)throws StockIdNotFoundException;
	 
	 
}
