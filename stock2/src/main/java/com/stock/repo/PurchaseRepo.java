package com.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.Purchase;


@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long>{

}
