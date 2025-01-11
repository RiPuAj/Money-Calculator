import es.ulpgc.moneycalulator.controller.CurrencyManager;
import es.ulpgc.moneycalulator.controller.ExchangeRateManager;
import es.ulpgc.moneycalulator.io.TsvCurrencyLoader;
import es.ulpgc.moneycalulator.io.TsvExchangeRateLoader;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File currencyFile = new File("monedas.tsv");
        File ExchangeRateFile = new File("exchangeRates.tsv");
        CurrencyManager currencyManager = new CurrencyManager();
        ExchangeRateManager exchangeRateManager = new ExchangeRateManager();
        TsvCurrencyLoader tsvCurrencyLoader = new TsvCurrencyLoader(currencyManager);
        tsvCurrencyLoader.readFrom(currencyFile);
        TsvExchangeRateLoader tsvExchangeLoader = new TsvExchangeRateLoader(exchangeRateManager);
        tsvExchangeLoader.readFrom(ExchangeRateFile);

    }
}
