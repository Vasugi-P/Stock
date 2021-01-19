package com.stock.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.stock.dto.MyStockdto;
import com.stock.dto.PurchaseResponseDto;
import com.stock.dto.StockDto;
import com.stock.dto.StockResponse;
import com.stock.entity.MyStock;
import com.stock.entity.Stock;
import com.stock.exception.StockIdNotFoundException;
import com.stock.exception.StockNameNotFoundException;
import com.stock.exception.StockNotFoundException;
import com.stock.repo.StockRepo;
import com.stock.service.impl.StockServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StockServiceTest {
	
	@Mock
	StockRepo repo;
	
	@InjectMocks
	StockServiceImpl stockImpl;
	
	Stock stock=null;
	StockDto stockDto=null;
	StockResponse response=null;
	
	List<Stock> liStock=null;
	
	MyStock mystock=null;
	MyStockdto mystockDto=null;
	PurchaseResponseDto responsedto=null;
	
	@Test
	public void testGetStockByName() throws StockNameNotFoundException{
		stock=new Stock();
		liStock=new ArrayList<Stock>();
		stock.setStockId(100L);
		stock.setStockName("LIC");
		liStock.add(stock);
		
		stockDto=new StockDto();
		stockDto.setStockId(100L);
		stockDto.setStockName("AXIS");
		
		Mockito.when(repo.findByStockNameContaining("LIC")).thenReturn(liStock);
	        List<StockDto> stock=stockImpl.getStocks("LIC");
	      assertEquals(stock.size(),liStock.size());	
		
	}
	
	
	
	@Test
	public void testStockById() throws StockIdNotFoundException{
		stock=new Stock();
		stock.setStockId(100L);
		
		Mockito.when(repo.findByStockId(100L)).thenReturn(Optional.of(stock));
		MyStockdto dto=(MyStockdto) stockImpl.getMyStock(100L);
		assertEquals(dto.getStockName(), stock.getStockName());
		
	}
	
	@Test(expected = StockIdNotFoundException.class)
	public void testStockByIdNegative() throws StockIdNotFoundException{
		stock=new Stock();
		stock.setStockId(100L);
		
		Mockito.when(repo.findByStockId(100L)).thenReturn(Optional.of(stock));
		MyStockdto dto=(MyStockdto) stockImpl.getMyStock(100L);
		assertEquals(dto.getStockName(), stock.getStockName());
		
	}
	
	
	
	@Test(expected = StockNotFoundException.class)
	public void testGetAllStockNegative() throws StockIdNotFoundException{
		stock=new Stock();
		stock.setStockId(100L);
		Mockito.when(repo.findById(100L)).thenReturn(Optional.of(stock));
		List<Stock> stock=stockImpl.getAllStock();
		assertEquals(stock.size(), HttpStatus.OK);
	}
	

}
