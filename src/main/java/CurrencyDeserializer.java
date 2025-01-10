import es.ulpgc.moneycalulator.model.Currency;

public interface CurrencyDeserializer {
    Currency deserialize(String line);
}
