package com.stock.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dto.MyStockdto;
import com.stock.dto.StockDto;
import com.stock.dto.StockResponse;
import com.stock.entity.MyStock;
import com.stock.entity.Stock;
import com.stock.exception.SearchStockNotFoundException;
import com.stock.exception.StockNameNotFoundException;
import com.stock.exception.StockNotFoundException;
import com.stock.exception.UserIdNotFoundException;
import com.stock.service.StockService;

@RestController
public class StockController {

	@Autowired
	StockService ss;

	Logger log = LoggerFactory.getLogger(PurchaseController.class);

	@GetMapping(value = "getAllStocks/stockId")
	public List<Stock> getAllStock() throws StockNotFoundException {
		log.info("Stock details are displayed");
		return ss.getAllStock();
	}

	@GetMapping(value = "search/stockName")
	public ResponseEntity<StockResponse> getStockbyStockName(@RequestParam String stockName)
			throws StockNameNotFoundException {
		StockResponse response = new StockResponse();

		List<StockDto> stockDto = ss.getStocks(stockName);
		if (stockDto.isEmpty()) {
			response.setStatusCode("404");
			return new ResponseEntity<StockResponse>(response, HttpStatus.NOT_FOUND);
		}
		response.setStockDto(stockDto);
		response.setStatusCode("200");
		return new ResponseEntity<StockResponse>(response, HttpStatus.OK);

	}

	
	@GetMapping(value="stocks/myStock/{userId}")
	public ResponseEntity<List<MyStockdto>>getStockByuserId(@RequestParam Long userId)throws UserIdNotFoundException{
		List<MyStockdto> stock=ss.getMyStock(userId);
		return new ResponseEntity<>(stock,HttpStatus.OK);
	}
	
}
