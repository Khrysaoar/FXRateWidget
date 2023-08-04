package com.martrust.FXRatesWidgets.service;

import com.martrust.FXRatesWidgets.request.ExchangeRequest;
import com.martrust.FXRatesWidgets.response.ExchangeResponse;

import java.io.IOException;
import java.net.ProtocolException;

public interface ExchangeService {
    /**
     * Searches for a reference rate within rates list
     * @param exchangeRateReq - request with targetCurrency
     * @return current conversion rate for target currency using data from ECB
     */
    ExchangeResponse getConversionRate(ExchangeRequest exchangeRateReq) throws IOException;


}
