package com.ing.stock.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseStockDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long stockId;
	private String stockName;
	private Double stockPrice;
}
