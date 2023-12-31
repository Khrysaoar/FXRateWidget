package com.martrust.FXRatesWidgets.service;

import com.martrust.FXRatesWidgets.request.ExchangeRateRequest;
import com.martrust.FXRatesWidgets.request.ExchangeRequest;
import com.martrust.FXRatesWidgets.response.ApilayerRatesResponse;
import com.martrust.FXRatesWidgets.response.CurrencyListResponse;
import com.martrust.FXRatesWidgets.response.ExchangeResponse;

import java.io.IOException;

public interface ExchangeService {
    /**
     * Searches for a reference rate within rates list
     * @param exchangeRateReq - request with targetCurrency
     * @return current conversion rate for target currency using data from ECB
     */
    ExchangeResponse getConversionRate(ExchangeRequest exchangeRateReq) throws IOException;

    ApilayerRatesResponse getForeignExchangeRate(ExchangeRateRequest exchangeRateReq);

    CurrencyListResponse getCurrencyList();
}
