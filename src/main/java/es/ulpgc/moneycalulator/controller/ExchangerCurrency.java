package es.ulpgc.moneycalulator.controller;

import es.ulpgc.moneycalulator.model.Currency;
import es.ulpgc.moneycalulator.model.ExchangeRate;

import java.util.List;

public class ExchangerCurrency {
    private final CurrencyManager currencyManager;
    private final ExchangeRateManager exchangeRateManager;

    public ExchangerCurrency(CurrencyManager currencyManager, ExchangeRateManager exchangeRateManager) {
        this.currencyManager = currencyManager;
        this.exchangeRateManager = exchangeRateManager;
    }

    public double conversionRate(double quantity, String from, String to) {
        if (from.equals(to)) return quantity;
        if (from.equals("USD")){
            ExchangeRate exchangeRate = exchangeRateManager.getExchangeRate(from, to);
            return quantity*exchangeRate.rate();
        }
        ExchangeRate exchangeRate = exchangeRateManager.getExchangeRate(from, "USD");

        return conversionRate(exchangeRate.rate()*quantity, "USD", to);
    }

    public List<Currency> getAllCurrencies(){
        return currencyManager.getAllCurrencies();
    }
}
