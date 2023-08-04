# NOTES
The developers did not use https://exchangeratesapi.io/ as the rate provider because it doesn't have free access to the base currency. So the developers have no way of telling what base should use.

# GOALS
This project aims to create an FX calculator. It gets exchange rates from [api.apilayer.com](https://api.apilayer.com/exchangerates_data/latest) 

# Free api.apilayer.com API Endpoint 
https://apilayer.com/marketplace/exchangerates_data-api


# To run Application locally
`mvn install && mvn spring-boot:run`


# To check API Documentation
Make sure you are running application locally. Afterwards, go to 

[Swagger Docs](http://localhost:8080/swagger-ui.html#/)
