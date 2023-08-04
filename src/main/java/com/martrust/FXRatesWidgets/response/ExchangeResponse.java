package com.martrust.FXRatesWidgets.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeResponse {
    @JsonProperty("success")
    Boolean success;
    @JsonProperty("convertFrom")
    String convertFrom;
    @JsonProperty("convertTo")
    String convertTo;
    @JsonProperty("latestRates")
    Double latestRates;
    @JsonProperty("rateToConvert")
    Double rateToConvert;
    @JsonProperty("convertedRate")
    Double convertedRate;
    @JsonProperty("sellOrBuy")
    String sellOrBuy;
    @JsonProperty("error")
    ErrorExchangeResponse errorExchangeResponse;
}
