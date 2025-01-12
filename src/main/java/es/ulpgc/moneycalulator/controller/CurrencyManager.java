package es.ulpgc.moneycalulator.controller;

import es.ulpgc.moneycalulator.model.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyManager {
    private List<Currency> currencies;

    public CurrencyManager() {
        this.currencies = new ArrayList<>();
    }

    public void addCurrency(String currencyLine) {
        Currency currency = deserialize(currencyLine);
        if (isAdded(currency)) return;
        this.currencies.add(currency);
    }

    public Currency deserialize(String currencyLine) {
        String[] lineSplit = currencyLine.split("\t");
        return new Currency(
                lineSplit[0],
                lineSplit[1],
                lineSplit[2]);
    }

    public Currency getCurrency(String currencyCode) {
        System.out.println(this.currencies);
        return this.currencies.stream()
                .filter(c -> c.code().equals(currencyCode))
                .findFirst()
                .orElse(null);
    }

    private boolean isAdded(Currency currency) {
        return currencies.contains(currency);
    }

    public List<Currency> getAllCurrencies() {
        return this.currencies;
    }
}
