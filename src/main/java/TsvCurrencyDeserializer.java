import es.ulpgc.moneycalulator.model.Currency;

public class TsvCurrencyDeserializer implements CurrencyDeserializer{

    @Override
    public Currency deserialize(String line) {
        String[] lineSplited = line.split("\t");
        return new Currency(
                lineSplited[0],
                lineSplited[1],
                lineSplited[2]);
    }
}
