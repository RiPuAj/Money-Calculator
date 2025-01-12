package es.ulpgc.moneycalulator.view;

import es.ulpgc.moneycalulator.controller.Command;
import es.ulpgc.moneycalulator.controller.ExchangeCommand;
import es.ulpgc.moneycalulator.controller.ExchangerCurrency;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SwingMain extends JFrame {
    private Map<String, Command> commands = new HashMap<>();
    private CurrencyDialog currencyFromDialog;
    private CurrencyDialog currencyToDialog;
    private final ExchangerCurrency exchangerCurrency;
    private ResultLabel resultLabel;
    private MoneyInput amountField;

    public SwingMain(ExchangerCurrency exchangerCurrency) {
        this.exchangerCurrency = exchangerCurrency;
        this.setTitle("Money Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.add(new JPanel().add(createAmountField()));
        this.add(createCurrencyFromJComboBox());
        this.add(createCurrencyToJComboBox());
        this.add(createResultLabel());
        this.add(calculateButton());
        createExchangeCommand();
    }

    private Component createCurrencyFromJComboBox(){
        CurrencyDialog currencyDialog = new CurrencyJComboBox();
        this.currencyFromDialog = currencyDialog;
        return (Component) currencyDialog;
    }

    private Component createCurrencyToJComboBox(){
        CurrencyDialog currencyDialog = new CurrencyJComboBox();
        this.currencyToDialog = currencyDialog;
        return (Component) currencyDialog;
    }

    private Component createResultLabel(){
        ResultLabel resultLabel = new ResultLabel();
        this.resultLabel = resultLabel;
        return (Component) resultLabel;
    }

    private Component calculateButton(){
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> commands.get("exchange").execute());
        return calculateButton;
    }

    private Component createAmountField(){
        MoneyInput amountField = new MoneyInput();
        this.amountField = amountField;
        return (Component) amountField;
    }

    public CurrencyDialog getCurrencyFromDialog() {
        return currencyFromDialog;
    }

    public CurrencyDialog getCurrencyToDialog() {
        return currencyToDialog;
    }

    public ResultLabel getResultLabel() {
        return resultLabel;
    }

    public MoneyInput getAmountField() {
        return amountField;
    }

    public void createExchangeCommand() {
        Command exchangeCommand = new ExchangeCommand(
                getCurrencyFromDialog().define(exchangerCurrency.getAllCurrencies()),
                getCurrencyToDialog().define(exchangerCurrency.getAllCurrencies()),
                exchangerCurrency,
                getResultLabel(),
                (MoneyInput) getAmountField());
        commands.put("exchange", exchangeCommand);
    }
}
