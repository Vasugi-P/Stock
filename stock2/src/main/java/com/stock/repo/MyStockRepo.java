package com.stock.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.MyStock;

@Repository
public interface MyStockRepo extends JpaRepository<MyStock, Long>{
	
	List<MyStock> findByUserId(Long userId);

}
