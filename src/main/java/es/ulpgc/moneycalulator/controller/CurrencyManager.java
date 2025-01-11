package es.ulpgc.moneycalulator.controller;

import es.ulpgc.moneycalulator.model.Currency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyManager {
    private final Map<String, Currency> currencies = new HashMap<>();

    public Currency getCurrency(String currencyCode) {
        return currencies.get(currencyCode);
    }

    public void addCurrency(String currencyLine) {
        Currency currency = deserialize(currencyLine);
        if (isAdded(currency)) return;
        currencies.put(currency.code(), currency);
    }

    public Currency deserialize(String currencyLine) {
        String[] lineSplited = currencyLine.split("\t");
        return new Currency(
                lineSplited[0],
                lineSplited[1],
                lineSplited[2]);
    }

    private boolean isAdded(Currency currency) {
        return currencies.containsKey(currency.code());
    }

    public List<Currency> getAllCurrencies() {
        return new ArrayList<>(currencies.values());
    }
}
