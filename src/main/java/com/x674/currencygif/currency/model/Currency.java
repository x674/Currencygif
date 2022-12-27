package com.x674.currencygif.currency.model;

import java.util.Map;

public class Currency {
    public String base;
    public Map<String,Double> rates;
    public double getCurrency(String currencyCode){
        return rates.get(currencyCode);
    };

}
