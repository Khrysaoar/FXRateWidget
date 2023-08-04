package com.martrust.FXRatesWidgets.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApilayerRatesResponse {
    @JsonProperty("success")
    Boolean success;
    @JsonProperty("timestamp")
    Timestamp timestamp;
    @JsonProperty("base")
    String convertFrom;
    @JsonProperty("date")
    Date date;
    @JsonProperty("rates")
    Map<String,Double> rates;
    @JsonProperty("error")
    ErrorExchangeResponse error;
}
