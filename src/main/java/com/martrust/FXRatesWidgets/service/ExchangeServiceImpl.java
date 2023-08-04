package com.martrust.FXRatesWidgets.service;

import com.martrust.FXRatesWidgets.request.ExchangeRequest;
import com.martrust.FXRatesWidgets.response.ExchangeResponse;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Override
    public ExchangeResponse getConversionRate(ExchangeRequest exchangeRateReq) throws IOException {
        // Setting URL
        String url_str = "https://api.apilayer.com/fixer/latest?base=" + exchangeRateReq.getConvertFrom() +
                "&symbols=" + exchangeRateReq.getConvertTo();

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
        System.out.println(http.getResponseCode() + " " + response.toString());
        http.disconnect();
        return null;
    }

    public Double getResult(Double valFrom, Double valTo) {
        Double convertedRate = valFrom*valTo;
        convertedRate = Double.parseDouble(String.format("%.2f", convertedRate));
        return convertedRate;
    }
}