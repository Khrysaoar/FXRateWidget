package com.martrust.FXRatesWidgets.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExchangeResponse {
    @JsonProperty("convertFrom")
    String convertFrom;
    @JsonProperty("convertTo")
    String convertTo;
    @JsonProperty("convertedRate")
    Double convertedRate;
    @JsonProperty("sellOrBuy")
    String sellOrBuy;
}
