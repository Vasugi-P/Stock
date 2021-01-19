package com.stock.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock, Long> {

	Optional<Stock> findByStockId(Long stockId);

	List<Stock> findByStockNameContaining(String stockName);

	

}
