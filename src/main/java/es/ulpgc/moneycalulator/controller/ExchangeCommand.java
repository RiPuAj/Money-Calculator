package es.ulpgc.moneycalulator.controller;

import es.ulpgc.moneycalulator.view.CurrencyDialog;
import es.ulpgc.moneycalulator.view.MoneyInput;
import es.ulpgc.moneycalulator.view.ResultLabel;

public class ExchangeCommand implements Command {
    private final CurrencyDialog currencyFromDialog;
    private final CurrencyDialog currencyToDialog;
    private final ExchangerCurrency exchangerCurrency;
    private final ResultLabel resultLabel;
    private final MoneyInput amountField;

    public ExchangeCommand(CurrencyDialog currencyFromDialog, CurrencyDialog currencyToDialog, ExchangerCurrency exchangerCurrency, ResultLabel resultLabel, MoneyInput amountField) {
        this.currencyFromDialog = currencyFromDialog;
        this.currencyToDialog = currencyToDialog;
        this.exchangerCurrency = exchangerCurrency;
        this.resultLabel = resultLabel;
        this.amountField = amountField;
    }

    @Override
    public void execute() {
        double quantity = Double.parseDouble(amountField.getMoneyInput().getText());
        double result = exchangerCurrency.conversionRate(
                quantity,
                currencyFromDialog.getCurrencySelected().code(),
                currencyToDialog.getCurrencySelected().code()
        );

        resultLabel.show(String.format("%.2f", result));
    }
}
