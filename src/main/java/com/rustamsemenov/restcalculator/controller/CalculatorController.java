package com.rustamsemenov.restcalculator.controller;

import com.rustamsemenov.restcalculator.exception_handling.IncorrectData;
import com.rustamsemenov.restcalculator.exception_handling.CalculateException;
import com.rustamsemenov.restcalculator.service.CalculatorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    @ApiOperation(value = "Сложение двух чисел.",  notes = "Введите два числа, которые хотите сложить.")
    public BigDecimal add(@RequestParam BigDecimal num1, @RequestParam BigDecimal num2) {
        return calculatorService.add(num1, num2);
    }

    @GetMapping("/subtract")
    @ApiOperation(value = "Разность двух чисел.",  notes = "Введите два числа, чью разность вы хотите получить.")
    public BigDecimal subtract(@RequestParam BigDecimal num1, @RequestParam BigDecimal num2) {
        return calculatorService.subtract(num1, num2);
    }

    @GetMapping("/multiply")
    @ApiOperation(value = "Умножение двух чисел.",  notes = "Введите два числа, чтобы получить их произведение.\n" +
            "Помните, при умножении на ноль - результат - ноль.")
    public BigDecimal multiply(@RequestParam BigDecimal num1, @RequestParam BigDecimal num2) {
        return calculatorService.multiply(num1, num2);
    }

    @GetMapping("/division")
    @ApiOperation(value = "Частное двух чисел.",  notes = "Введите делимое и делитель.\n" +
            "Помните, на ноль делать нельзя!")
    public BigDecimal division(@RequestParam BigDecimal num1, @RequestParam BigDecimal num2) {
        if (num2.equals(BigDecimal.ZERO)) {
            throw new CalculateException("На ноль делить нельзя.");
        }
        return calculatorService.division(num1, num2);
    }
}
