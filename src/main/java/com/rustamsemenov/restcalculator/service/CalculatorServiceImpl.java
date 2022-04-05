package com.rustamsemenov.restcalculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal add(BigDecimal add1, BigDecimal add2) {
        return add1.add(add2);
    }

    @Override
    public BigDecimal subtract(BigDecimal minuend, BigDecimal subtrahend) {
        return minuend.subtract(subtrahend);
    }

    @Override
    public BigDecimal multiply(BigDecimal multiplierOne, BigDecimal multiplierTwo) {
        return multiplierOne.multiply(multiplierTwo);
    }

    @Override
    public BigDecimal division(BigDecimal dividend, BigDecimal divider) {

        return dividend.divide(divider, 4,  RoundingMode.HALF_EVEN);
    }
}
