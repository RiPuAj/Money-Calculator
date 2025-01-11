package es.ulpgc.moneycalulator.controller;

import es.ulpgc.moneycalulator.model.Currency;
import es.ulpgc.moneycalulator.model.ExchangeRate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRateManager {
    private final CurrencyManager currencyManager;
    private final List<ExchangeRate> exchangeRates = new ArrayList<>();

    public ExchangeRateManager() {
        this.currencyManager = new CurrencyManager();
    }

    public void addExchangeRate(String exchangeRateLine) {
        ExchangeRate exchangeRate = deserialize(exchangeRateLine);
        if (!isAdded(exchangeRate)) return;
        exchangeRates.add(exchangeRate);
    }

    private boolean isAdded(ExchangeRate exchangeRate) {
        return exchangeRates.contains(exchangeRate);
    }

    public ExchangeRate deserialize(String line){
        String[] lineSplit = line.split("\\s+");

        Currency fromCurrency = currencyManager.getCurrency(lineSplit[0]);
        Currency toCurrency = currencyManager.getCurrency(lineSplit[1]);

        return new ExchangeRate(
                fromCurrency,
                toCurrency,
                Double.parseDouble(lineSplit[2]),
                LocalDate.now()
        );
    }
}
