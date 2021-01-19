package com.stock.service.impl;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dto.MyStockdto;
import com.stock.dto.StockDto;
import com.stock.entity.MyStock;
import com.stock.entity.Stock;
import com.stock.exception.SearchStockNotFoundException;
import com.stock.exception.StockIdNotFoundException;
import com.stock.repo.MyStockRepo;
import com.stock.repo.StockRepo;
import com.stock.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepo stockRepo;

	@Autowired
	MyStockRepo myStockRepo;

	Logger log = LoggerFactory.getLogger(StockServiceImpl.class);

	@Override
	public List<Stock> getAllStock() {

		log.info("Display the stock details");
		return stockRepo.findAll();

	}

	@Override
	public List<StockDto> getStocks(String stockName) {
		List<StockDto> stockList = new ArrayList<>();
		List<Stock> stocks = stockRepo.findByStockNameContaining(stockName);
		stocks.forEach(sto -> {
			StockDto stoc = new StockDto();
			BeanUtils.copyProperties(sto, stoc);
			stockList.add(stoc);
		});
		return stockList;
	}

	
	@Override
	public List<MyStockdto> getMyStock(Long userId) throws StockIdNotFoundException {
		List<MyStock>stock=myStockRepo.findByUserId(userId);
		
	List<MyStockdto> myStockdto =stock.stream().map(stock1->{
		MyStockdto my=new MyStockdto();
		my.setPurchaseId(stock1.getPurchaseId());
		my.setQuantity(stock1.getQuantity());
		my.setStockName(stock1.getStockName());
		my.setTotalPurchaseAmount(stock1.getTotalPurchaseAmount());
		my.setUserId(stock1.getUserId());
		my.setStockprice(stock1.getStockprice());
		BeanUtils.copyProperties(stock1, my);
		return my;
	}).collect(Collectors.toList());
	return myStockdto;
		

	}
	

}
