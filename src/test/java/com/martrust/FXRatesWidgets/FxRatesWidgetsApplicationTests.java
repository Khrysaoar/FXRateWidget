package com.martrust.FXRatesWidgets;

import com.martrust.FXRatesWidgets.request.ExchangeRateRequest;
import com.martrust.FXRatesWidgets.request.ExchangeRequest;
import com.martrust.FXRatesWidgets.response.ApilayerRatesResponse;
import com.martrust.FXRatesWidgets.response.CurrencyListResponse;
import com.martrust.FXRatesWidgets.response.ExchangeResponse;
import com.martrust.FXRatesWidgets.service.ExchangeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FxRatesWidgetsApplicationTests {
    ExchangeServiceImpl svc = new ExchangeServiceImpl();
    @Test
    public void SuccessExchangeServiceImplTests() {
        ExchangeRequest xReq = new ExchangeRequest();
        xReq.setRate(5.0);
        xReq.setConvertFrom("USD");
        xReq.setConvertTo("PHP");
        xReq.setSellOrBuy("Buy");

        ExchangeResponse res = svc.getConversionRate(xReq);
        assertEquals(res.getSuccess(), true);
    }

    @Test
    public void FailedExchangeServiceImplTests() {
        ExchangeRequest xReq = new ExchangeRequest();

        ExchangeResponse res = svc.getConversionRate(xReq);
        assertEquals(res.getSuccess(), false);
    }

    @Test
    public void SuccessExchangeRateServiceImplTests() {
        ExchangeRateRequest xReq = new ExchangeRateRequest();
        xReq.setBase("USD");
        xReq.setSymbol("PHP");

        ApilayerRatesResponse res = svc.getForeignExchangeRate(xReq);
        assertEquals(res.getSuccess(), true);
    }

    @Test
    public void FailedExchangeRateServiceImplTests() {
        ExchangeRateRequest xReq = new ExchangeRateRequest();

        ApilayerRatesResponse res = svc.getForeignExchangeRate(xReq);
        assertEquals(res.getSuccess(), false);
    }

    @Test
    public void SuccessGetCurrencyListTests() {
        CurrencyListResponse res = svc.getCurrencyList();
        assertEquals(res.getSuccess(), true);
    }
}
