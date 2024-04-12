package services;

import models.ExchangeRate;

public class CalculateRates {
    public double convert(String currency, String convert, double amount) {

        ApiConnection api = new ApiConnection();
        ExchangeRate data = api.findCoin(currency);
        return amount * data.conversion_rates().get(convert);
    }
}
