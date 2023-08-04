package com.martrust.FXRatesWidgets.controller;

import com.martrust.FXRatesWidgets.request.ExchangeRequest;
import com.martrust.FXRatesWidgets.response.ExchangeResponse;
import com.martrust.FXRatesWidgets.service.ExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/rates")
@AllArgsConstructor
public class ExchangeRateController {

    private final ExchangeService exchangeRateService;

    @PostMapping("/get/rate")
    public ResponseEntity<ExchangeResponse> getExchangeRate(@RequestBody ExchangeRequest exchangeRequest) throws IOException {

        return ResponseEntity.ok(exchangeRateService.getConversionRate(exchangeRequest));
    }

}