package com.stock.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dto.PurchaseDto;
import com.stock.dto.PurchaseResponseDto;
import com.stock.dto.StockDto;
import com.stock.dto.StockResponse;
import com.stock.entity.MyStock;
import com.stock.entity.Purchase;
import com.stock.entity.Stock;
import com.stock.exception.SearchStockNotFoundException;
import com.stock.exception.StockIdNotFoundException;
import com.stock.exception.StockNameNotFoundException;
import com.stock.exception.StockNotFoundException;
import com.stock.exception.StockQuantityNotFoundException;
import com.stock.exception.UserIdNotFoundException;
import com.stock.service.PurchaseService;
import com.stock.service.StockService;

@RestController
public class PurchaseController {

	@Autowired
	PurchaseService ps;

	@Autowired
	StockService ss;

	Logger log = LoggerFactory.getLogger(PurchaseController.class);

	@PostMapping(value = "stock/purchase")
	public ResponseEntity<PurchaseResponseDto> stockPurchase(@RequestBody PurchaseDto purchaseDto)
			throws StockIdNotFoundException, UserIdNotFoundException {
		
		Purchase purchase=ps.purchaseStock(purchaseDto);
		
		PurchaseResponseDto res = new PurchaseResponseDto();
		
		res.setMessage("Stock Purchased Successfully");
		res.setStatusCode("201");
		log.info("Stock Purchased Successfully");
		return new ResponseEntity<PurchaseResponseDto>(res, HttpStatus.CREATED);
	}

	

	
}
