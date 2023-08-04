package com.martrust.FXRatesWidgets.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyListResponse {
    @JsonProperty("success")
    Boolean success;
    @JsonProperty("currencyList")
    List<String> currencyList;
    @JsonProperty("error")
    ErrorExchangeResponse error;
}
