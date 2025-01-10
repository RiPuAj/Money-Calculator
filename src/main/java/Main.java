import es.ulpgc.moneycalulator.model.Currency;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TsvCurrencyReader tsvCurrencyReader = new TsvCurrencyReader();
        List<Currency> currencies = tsvCurrencyReader.readFrom(new File("monedas.tsv"));
    }
}
