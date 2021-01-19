package com.stock.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyStock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long myStockId;
	private Long userId;
	private Long purchaseId;
	private String stockName;
	private int quantity;
	private double stockprice;
	private double totalPurchaseAmount;
	
	public MyStock(Long userId, Long purchaseId, String stockName, int quantity, double stockprice,
			double totalPurchaseAmount) {
		super();
		this.userId = userId;
		this.purchaseId = purchaseId;
		this.stockName = stockName;
		this.quantity = quantity;
		this.stockprice = stockprice;
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	
	public MyStock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getMyStockId() {
		return myStockId;
	}
	public void setMyStockId(Long myStockId) {
		this.myStockId = myStockId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getStockprice() {
		return stockprice;
	}
	public void setStockprice(double stockprice) {
		this.stockprice = stockprice;
	}
	public double getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}
	public void setTotalPurchaseAmount(double totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	
	
	


}
