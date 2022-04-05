package com.rustamsemenov.restcalculator.service;

import java.math.BigDecimal;

public interface CalculatorService {

    public BigDecimal add(BigDecimal one, BigDecimal two);

    public BigDecimal  subtract(BigDecimal one, BigDecimal two);

    public BigDecimal multiply(BigDecimal one, BigDecimal two);

    public BigDecimal division(BigDecimal one, BigDecimal two);

}
