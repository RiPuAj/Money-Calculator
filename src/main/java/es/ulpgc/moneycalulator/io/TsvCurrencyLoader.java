package es.ulpgc.moneycalulator.io;

import java.io.*;

public class TsvCurrencyLoader {
    private final CurrencyManager currencyManager;

    public TsvCurrencyLoader(CurrencyManager currencyManager) {
        this.currencyManager = currencyManager;
    }


    public void readFrom(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            readHeader(reader);

            while (true){
                String line = reader.readLine();
                if (line == null) break;
                currencyManager.addCurrency(line);
            }

        } catch (IOException e) {
            //TODO
        }
    }

    private void readHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }

}
