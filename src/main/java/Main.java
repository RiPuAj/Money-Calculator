import es.ulpgc.moneycalulator.controller.CurrencyManager;
import es.ulpgc.moneycalulator.controller.ExchangeRateManager;
import es.ulpgc.moneycalulator.controller.ExchangerCurrency;
import es.ulpgc.moneycalulator.io.TsvCurrencyLoader;
import es.ulpgc.moneycalulator.io.TsvExchangeRateLoader;
import es.ulpgc.moneycalulator.view.SwingMain;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CurrencyManager currencyManager = new CurrencyManager();
        TsvCurrencyLoader tsvCurrencyLoader = new TsvCurrencyLoader(currencyManager)
                .loadFrom(new File("monedas.tsv"));

        ExchangeRateManager exchangeRateManager = new ExchangeRateManager();
        TsvExchangeRateLoader tsvExchangeLoader = new TsvExchangeRateLoader(exchangeRateManager)
                .loadFrom(new File("exchangeRates.tsv"));

        ExchangerCurrency exchangerCurrency = new ExchangerCurrency(currencyManager, exchangeRateManager);
        SwingMain swingMain = new SwingMain(exchangerCurrency);
        swingMain.setVisible(true);

    }

}
