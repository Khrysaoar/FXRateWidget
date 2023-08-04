# GOALS
This project aims to create an FX calculator. It gets exchange rates from [api.apilayer.com](https://api.apilayer.com/exchangerates_data/latest) 

# Limitations
Public API of _api.apilayer.com_ gives rates with a random base for free subscription. In this project, we have `EUR` as `BASE_CURRENCY`. 

# Free api.apilayer.com API Endpoint 
https://apilayer.com/marketplace/exchangerates_data-api


# To run Application locally
`mvn install && mvn spring-boot:run`


# To check API Documentation
Make sure you are running application locally. Afterwards, go to 

[Swagger Docs](http://localhost:8080/swagger-ui.html#/)
