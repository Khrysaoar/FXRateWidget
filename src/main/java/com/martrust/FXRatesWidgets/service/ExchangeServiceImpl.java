package com.martrust.FXRatesWidgets.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.martrust.FXRatesWidgets.request.ExchangeRateRequest;
import com.martrust.FXRatesWidgets.request.ExchangeRequest;
import com.martrust.FXRatesWidgets.response.ApilayerRatesResponse;
import com.martrust.FXRatesWidgets.response.CurrencyListResponse;
import com.martrust.FXRatesWidgets.response.ErrorExchangeResponse;
import com.martrust.FXRatesWidgets.response.ExchangeResponse;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Override
    public ExchangeResponse getConversionRate(ExchangeRequest exchangeRateReq) {
        // Setting URL
        String url_str = "https://api.apilayer.com/fixer/latest?base=" + exchangeRateReq.getConvertFrom() +
                "&symbols=" + exchangeRateReq.getConvertTo();

        ExchangeResponse finalResponse = new ExchangeResponse();
        try {
            URL url = new URL(url_str);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setRequestProperty("apikey", "ky8z18sA76MYBBXH0uWFfIHBy87xWSkI");
            http.setRequestProperty("Accept", "application/json");
            http.setRequestMethod("GET");

            //Get Response
            InputStream is = http.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            ObjectMapper mapper = new ObjectMapper();
            ApilayerRatesResponse fxResponse = mapper.readValue(response.toString(), ApilayerRatesResponse.class);
            if (http.getResponseCode() == 200) {
                finalResponse.setSuccess(fxResponse.getSuccess());
                finalResponse.setConvertFrom(exchangeRateReq.getConvertFrom());
                finalResponse.setConvertTo(exchangeRateReq.getConvertTo());
                finalResponse.setLatestRates(fxResponse.getRates().get(exchangeRateReq.getConvertTo()));
                finalResponse.setRateToConvert(exchangeRateReq.getRate());
                finalResponse.setConvertedRate(exchangeRateReq.getRate() * finalResponse.getLatestRates());
                finalResponse.setSellOrBuy(exchangeRateReq.getSellOrBuy());
                http.disconnect();
                return finalResponse;
            }
            ErrorExchangeResponse error = new ErrorExchangeResponse();
            error.setErrorCode(http.getResponseCode());
            error.setErrorMessage(http.getResponseMessage());
            finalResponse.setSuccess(false);
            finalResponse.setErrorExchangeResponse(error);
            return finalResponse;
        } catch(Exception ex) {
            ErrorExchangeResponse error = new ErrorExchangeResponse();
            error.setErrorCode(400);
            error.setErrorMessage(ex.getMessage());
            finalResponse.setSuccess(false);
            finalResponse.setErrorExchangeResponse(error);
            return finalResponse;
        }
    }

    @Override
    public ApilayerRatesResponse getForeignExchangeRate(ExchangeRateRequest exchangeRateReq) {
        // Setting URL
        String url_str = "https://api.apilayer.com/fixer/latest?base=" + exchangeRateReq.getBase() +
                "&symbols=" + exchangeRateReq.getSymbol();

        try {
            URL url = new URL(url_str);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setRequestProperty("apikey", "ky8z18sA76MYBBXH0uWFfIHBy87xWSkI");
            http.setRequestProperty("Accept", "application/json");
            http.setRequestMethod("GET");

            //Get Response
            InputStream is = http.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            ObjectMapper mapper = new ObjectMapper();
            ApilayerRatesResponse fxResponse = mapper.readValue(response.toString(), ApilayerRatesResponse.class);
            if (http.getResponseCode() == 200) {
                return fxResponse;
            }
            ErrorExchangeResponse error = new ErrorExchangeResponse();
            error.setErrorCode(http.getResponseCode());
            error.setErrorMessage(http.getResponseMessage());
            fxResponse.setSuccess(false);
            fxResponse.setError(error);
            return fxResponse;
        } catch(Exception ex) {
            ApilayerRatesResponse fxResponse = new ApilayerRatesResponse();
            ErrorExchangeResponse error = new ErrorExchangeResponse();
            error.setErrorCode(400);
            error.setErrorMessage(ex.getMessage());
            fxResponse.setSuccess(false);
            fxResponse.setError(error);
            return fxResponse;
        }
    }

    @Override
    public CurrencyListResponse getCurrencyList() {
        // Setting URL
        String url_str = "https://api.apilayer.com/fixer/latest";
        CurrencyListResponse currListResponse = new CurrencyListResponse();
        try {
            URL url = new URL(url_str);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setRequestProperty("apikey", "ky8z18sA76MYBBXH0uWFfIHBy87xWSkI");
            http.setRequestProperty("Accept", "application/json");
            http.setRequestMethod("GET");

            //Get Response
            InputStream is = http.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            ObjectMapper mapper = new ObjectMapper();
            ApilayerRatesResponse fxResponse = mapper.readValue(response.toString(), ApilayerRatesResponse.class);
            if (http.getResponseCode() == 200) {
                List<String> currencyList = new ArrayList<>(fxResponse.getRates().keySet());
                currListResponse.setSuccess(true);
                currListResponse.setCurrencyList(currencyList);
                return currListResponse;
            }
            ErrorExchangeResponse error = new ErrorExchangeResponse();
            error.setErrorCode(http.getResponseCode());
            error.setErrorMessage(http.getResponseMessage());
            currListResponse.setSuccess(false);
            currListResponse.setError(error);
            return currListResponse;
        } catch(Exception ex) {
            ErrorExchangeResponse error = new ErrorExchangeResponse();
            error.setErrorCode(400);
            error.setErrorMessage(ex.getMessage());
            currListResponse.setSuccess(false);
            currListResponse.setError(error);
            return currListResponse;
        }
    }
}