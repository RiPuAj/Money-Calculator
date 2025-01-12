package es.ulpgc.moneycalulator.view;

import es.ulpgc.moneycalulator.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CurrencyJComboBox extends JPanel implements CurrencyDialog{

    private JComboBox<Currency> currencyComboBox;

    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        add(createCurrencyComboBox(currencies));
        return this;
    }

    private Component createCurrencyComboBox(List<Currency> currencies) {
        JComboBox<Currency> comboBox = new JComboBox<>();
        for (Currency currency : currencies) comboBox.addItem(currency);
        this.currencyComboBox = comboBox;
        return comboBox;
    }

    @Override
    public Currency getCurrencySelected() {
        return currencyComboBox.getItemAt(currencyComboBox.getSelectedIndex());
    }
}
