package com.martrust.FXRatesWidgets.controller;

import com.martrust.FXRatesWidgets.request.ExchangeRateRequest;
import com.martrust.FXRatesWidgets.request.ExchangeRequest;
import com.martrust.FXRatesWidgets.response.ApilayerRatesResponse;
import com.martrust.FXRatesWidgets.response.CurrencyListResponse;
import com.martrust.FXRatesWidgets.response.ExchangeResponse;
import com.martrust.FXRatesWidgets.service.ExchangeService;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/rates")
@AllArgsConstructor
public class ExchangeRateController {

    private final ExchangeService exchangeRateService;

    @RequestMapping(value = "/convert/rate", method = RequestMethod.POST)
    @Operation(summary = "Get Foreign Exchange Rate", description = "Gets desired exchange rate from-to")
    public ResponseEntity<ExchangeResponse> getExchangeRate(@ApiParam(value = "ExchangeRequest : Request body that accepts convertFrom, convertTo, rate, and sellOrBuy", required = true)
                                                                @RequestBody ExchangeRequest exchangeRequest) throws IOException {
        return ResponseEntity.ok(exchangeRateService.getConversionRate(exchangeRequest));
    }

    @RequestMapping(value = "/get/rate", method = RequestMethod.POST)
    @Operation(summary = "Get Current Exchange Rate", description = "Gets the current exchange rate from-to")
    public ResponseEntity<ApilayerRatesResponse> getForeignExchangeRate(@ApiParam(value = "ExchangeRateRequest : Request body that accepts base and symbol", required = true)
                                                                            @RequestBody ExchangeRateRequest exchangeRateRequest) throws IOException {
        return ResponseEntity.ok(exchangeRateService.getForeignExchangeRate(exchangeRateRequest));
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @Operation(summary = "Get Currency List", description = "Gets the latest currency list")
    public ResponseEntity<CurrencyListResponse> getCurrencyList() throws IOException {
        return ResponseEntity.ok(exchangeRateService.getCurrencyList());
    }

}