import es.ulpgc.moneycalulator.model.Currency;

import java.io.File;
import java.util.List;

public interface CurrencyReader {
    List<Currency> readFrom(File file);
}
