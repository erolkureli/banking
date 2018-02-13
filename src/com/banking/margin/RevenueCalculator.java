package com.banking.margin;

import java.math.BigDecimal;

public interface RevenueCalculator {
	BigDecimal calculateRevenue(BigDecimal marginPercentage, BigDecimal costOfGoods);

}
