package com.rustamsemenov.restcalculator.controller;

import com.rustamsemenov.restcalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public BigDecimal add(@RequestParam BigDecimal add1,@ RequestParam BigDecimal add2) {
       return calculatorService.add(add1, add2);
    }

    @GetMapping("/subtract")
    public BigDecimal subtract(@RequestParam BigDecimal minuend, @RequestParam BigDecimal subtrahend) {
        return calculatorService.subtract(minuend,subtrahend);
    }

    @GetMapping("/multiply")
    public BigDecimal multiply(@RequestParam BigDecimal multiplierOne,@RequestParam  BigDecimal multiplierTwo) {
        return calculatorService.multiply(multiplierOne, multiplierTwo);
    }

    @GetMapping("division")
    public BigDecimal division(@RequestParam BigDecimal dividend, @RequestParam BigDecimal divider) {
        return calculatorService.division(dividend, divider);
    }
}
