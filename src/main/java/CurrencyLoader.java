import es.ulpgc.moneycalulator.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> loadCurrencies();
}
