package es.ulpgc.moneycalulator.view;

import javax.swing.*;
import java.awt.*;

public class MoneyInput extends JPanel {

    private JTextField moneyInput;

    public MoneyInput() {
        add(createAmountField());
    }

    public Component createAmountField(){
        JTextField textField = new JTextField();
        textField.setColumns(5);
        textField.setPreferredSize(new Dimension(100, 25));
        this.moneyInput = textField;
        return textField;
    }

    public JTextField getMoneyInput() {
        return moneyInput;
    }
}
