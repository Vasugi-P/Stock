package com.stock.service.impl;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dto.PurchaseDto;
import com.stock.entity.Purchase;
import com.stock.entity.Stock;
import com.stock.entity.User;
import com.stock.exception.StockIdNotFoundException;
import com.stock.exception.StockQuantityNotFoundException;
import com.stock.exception.UserIdNotFoundException;
import com.stock.repo.PurchaseRepo;
import com.stock.repo.StockRepo;
import com.stock.repo.UserRepo;
import com.stock.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseRepo purchaseRepo;
	
	@Autowired
	StockRepo stockRepo;

	
	Logger log=LoggerFactory.getLogger(PurchaseServiceImpl.class);

	@Override
	public Purchase purchaseStock(PurchaseDto purchaseDto)throws StockIdNotFoundException, UserIdNotFoundException {
		
		Optional<Stock> stock=stockRepo.findByStockId(purchaseDto.getStockId());
		
		int quantity=purchaseDto.getQuantity();
		
		stock.get().setStockQuantity(stock.get().getStockQuantity() - purchaseDto.getQuantity());
		stockRepo.save(stock.get());
		
		Purchase purchase=new Purchase();
		BeanUtils.copyProperties(purchase, purchaseDto);
		purchase.setTotalAmount(purchaseDto.getStockPrice() * purchaseDto.getQuantity());
	
		return purchaseRepo.save(purchase);
		
		
	}

}
