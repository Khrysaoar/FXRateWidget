package com.martrust.FXRatesWidgets.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateRequest {
    @JsonProperty("base")
    String base;
    @JsonProperty("symbol")
    String symbol;
}
