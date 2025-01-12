package es.ulpgc.moneycalulator.io;

import es.ulpgc.moneycalulator.controller.CurrencyManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TsvCurrencyLoader implements TsvLoader{
    private final CurrencyManager currencyManager;


    public TsvCurrencyLoader(CurrencyManager currencyManager) {
        this.currencyManager = currencyManager;
    }

    @Override
    public TsvCurrencyLoader loadFrom(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            readHeader(reader);

            while (true){
                String line = reader.readLine();
                if (line == null) break;
                currencyManager.addCurrency(line);
            }
            return this;

        } catch (IOException e) {
            //TODO
            return this;

        }
    }

    private void readHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }

}
