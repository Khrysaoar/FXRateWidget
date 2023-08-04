package com.martrust.FXRatesWidgets.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorExchangeResponse {
    @JsonProperty("errorCode")
    int errorCode;
    @JsonProperty("errorMessage")
    String errorMessage;
}
