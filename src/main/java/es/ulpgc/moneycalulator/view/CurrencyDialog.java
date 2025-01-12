package es.ulpgc.moneycalulator.view;

import es.ulpgc.moneycalulator.model.Currency;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<Currency> currencies);
    Currency getCurrencySelected();
}
