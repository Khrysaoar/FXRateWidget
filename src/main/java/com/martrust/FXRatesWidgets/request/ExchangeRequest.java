package com.martrust.FXRatesWidgets.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRequest {
    @JsonProperty("convertFrom")
    String convertFrom;
    @JsonProperty("convertTo")
    String convertTo;
    @JsonProperty("rate")
    Double rate;
    @JsonProperty("sellOrBuy")
    String sellOrBuy;
}
