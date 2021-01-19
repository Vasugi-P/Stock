package com.stock.service;

import com.stock.dto.PurchaseDto;
import com.stock.entity.Purchase;
import com.stock.exception.StockIdNotFoundException;
import com.stock.exception.StockQuantityNotFoundException;
import com.stock.exception.UserIdNotFoundException;


public interface PurchaseService {
	
	Purchase purchaseStock(PurchaseDto purchaseDto)throws StockIdNotFoundException, UserIdNotFoundException;

}
