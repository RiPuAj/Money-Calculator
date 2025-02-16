package es.ulpgc.moneycalulator.io;

import es.ulpgc.moneycalulator.controller.ExchangeRateManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TsvExchangeRateLoader {
    private final ExchangeRateManager exchangeRateManager;

    public TsvExchangeRateLoader(ExchangeRateManager manager) {
        this.exchangeRateManager = manager;
    }


    public TsvExchangeRateLoader loadFrom(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            readHeader(reader);

            while (true){
                String line = reader.readLine();
                if (line == null) break;
                exchangeRateManager.addExchangeRate(line);
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

