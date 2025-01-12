package es.ulpgc.moneycalulator.model;

public record Currency(String name, String symbol, String code) {
    @Override
    public String toString() {
        return code + " " + symbol;
    }
}
