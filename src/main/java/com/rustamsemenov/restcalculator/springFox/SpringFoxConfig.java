package com.rustamsemenov.restcalculator.springFox;


import com.rustamsemenov.restcalculator.controller.CalculatorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@Import(CalculatorController.class)
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rustamsemenov.restcalculator.controller"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST-Calculator API",
                "Simple Spring Boot Rest - Calculator.",
                "0.1",
                "Terms of service",
                new Contact(
                        "Rustam Semenov",
                        "https://vk.com/rustamkaa17",
                        "zeevvsss@yandex.ru"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
}
