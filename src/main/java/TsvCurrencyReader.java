import es.ulpgc.moneycalulator.model.Currency;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvCurrencyReader implements CurrencyReader{
    private final TsvCurrencyDeserializer deserializer;

    public TsvCurrencyReader() {
        this.deserializer = new TsvCurrencyDeserializer();
    }
    @Override
    public List<Currency> readFrom(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            readHeader(reader);
            List<Currency> currencies = new ArrayList<>();
            while (true){
                String line = reader.readLine();
                if (line == null) break;
                currencies.add(deserializer.deserialize(line));
            }
            return currencies;

        } catch (IOException e) {
            //TODO
            return null;
        }
    }

    private void readHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }

}
