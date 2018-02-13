package com.banking.margin;

import java.math.BigDecimal;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RevenueCalculatorService implements RevenueCalculator{

	@Override
	public BigDecimal calculateRevenue(BigDecimal marginPercentage, BigDecimal costOfGoods) {
		final int SCALE = 2;
		final BigDecimal HUNDRED_PERCENT_CONSTANT = new BigDecimal("1.0");
		
		BigDecimal ratio = HUNDRED_PERCENT_CONSTANT.subtract(marginPercentage);
		BigDecimal revenue = costOfGoods.divide(ratio,SCALE, BigDecimal.ROUND_HALF_UP);
		return revenue;
	}
	
	@Test
	public void testRevenue() {
		BigDecimal marginPercentage = new BigDecimal("0.2");
		BigDecimal costOfGoods = new BigDecimal("400");
		
		assertEquals(calculateRevenue(marginPercentage, costOfGoods), new BigDecimal("500.00"));
	}

}
