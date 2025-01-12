package es.ulpgc.moneycalulator.controller;

import es.ulpgc.moneycalulator.model.ExchangeRate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRateManager {
    private final List<ExchangeRate> exchangeRates = new ArrayList<>();


    public ExchangeRate getExchangeRate(String codeFrom, String codeTo){

        return exchangeRates.stream().
                filter(e -> e.codeFrom().equals(codeFrom) && e.codeTo().equals(codeTo))
                .findFirst()
                .orElse(null);
    }

    public void addExchangeRate(String exchangeRateLine) {
        ExchangeRate exchangeRate = deserialize(exchangeRateLine);
        if (isAdded(exchangeRate)) return;
        exchangeRates.add(exchangeRate);
    }

    private boolean isAdded(ExchangeRate exchangeRate) {
        return exchangeRates.contains(exchangeRate);
    }

    public ExchangeRate deserialize(String line){
        String[] lineSplit = line.split("\\s+");

        return new ExchangeRate(
                lineSplit[0],
                lineSplit[1],
                Double.parseDouble(lineSplit[2]),
                LocalDate.now()
        );
    }

    public List<ExchangeRate> getAllExchangesRates() {
        return exchangeRates;
    }
}
