package com.stock.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.stock.dto.PurchaseDto;
import com.stock.entity.Purchase;
import com.stock.exception.StockIdNotFoundException;
import com.stock.exception.StockQuantityNotFoundException;
import com.stock.exception.UserIdNotFoundException;
import com.stock.repo.PurchaseRepo;
import com.stock.service.impl.PurchaseServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseServiceTest {
	
	@InjectMocks
	PurchaseServiceImpl purchaseImpl;
	
	@Mock
	PurchaseRepo repo;
	
	Purchase purchase=null;
	PurchaseDto purchaseDto=null;
	
	@Test
	public void testPurchase() throws StockIdNotFoundException, StockQuantityNotFoundException, UserIdNotFoundException {
		
		purchase=new Purchase();
		purchase.setUserId(1L);
		purchase.setPurchaseDate("2020-03-09");
		purchase.setQuantity(2);
		purchase.setStockId(1L);
		purchase.setStockName("AXIS Loan");
		purchase.setStockPrice(200.0);
		
		purchaseDto=new PurchaseDto();
		purchaseDto.setUserId(1L);
		purchaseDto.setPurchaseDate("2020-03-09");
		purchaseDto.setQuantity(2);
		purchaseDto.setStockId(1L);
		purchaseDto.setStockName("AXIS Loan");
		purchaseDto.setStockPrice(200.0);
		
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(purchase));
		Mockito.when(repo.save(purchase)).thenReturn(purchase);
		Purchase purchase=purchaseImpl.purchaseStock(purchaseDto);
		assertEquals(purchaseDto.getUserId(),purchase.getUserId());
	}

}
