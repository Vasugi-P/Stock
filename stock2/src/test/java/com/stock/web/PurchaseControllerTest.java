package com.stock.web;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.stock.dto.PurchaseDto;
import com.stock.dto.PurchaseResponseDto;
import com.stock.entity.Purchase;
import com.stock.exception.StockIdNotFoundException;
import com.stock.exception.StockQuantityNotFoundException;
import com.stock.exception.UserIdNotFoundException;
import com.stock.service.PurchaseService;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseControllerTest {
	
	@Mock
	private PurchaseService purchaseService;
	
	@InjectMocks
	private PurchaseController purchaseControl;
	
	Purchase purchase=null;
	PurchaseDto purchaseDto=null;
	
	@Test
	public void testStockPurchase() throws StockIdNotFoundException, StockQuantityNotFoundException, UserIdNotFoundException {
		purchase=new Purchase();
		purchase.setUserId(1L);
		purchase.setPurchaseDate("2020-03-09");
		purchase.setQuantity(2);
		purchase.setStockId(1L);
		purchase.setStockName("AXIS Loan");
		purchase.setStockPrice(200.0);
		
		purchaseDto=new PurchaseDto();
		purchaseDto.setUserId(1L);
		purchaseDto.setPurchaseDate("2020-09-10");
		purchaseDto.setQuantity(2);
		purchaseDto.setStockId(1L);
		purchaseDto.setStockName("AXIS Loan");
		purchaseDto.setStockPrice(200.0);
		
		
		Mockito.when(purchaseService.purchaseStock(purchaseDto)).thenReturn(purchase);
		ResponseEntity<PurchaseResponseDto> res=purchaseControl.stockPurchase(purchaseDto);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());	
	}

}
