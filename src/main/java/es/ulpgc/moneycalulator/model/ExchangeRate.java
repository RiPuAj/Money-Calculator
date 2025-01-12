package es.ulpgc.moneycalulator.model;

import java.time.LocalDate;

public record ExchangeRate(String codeFrom, String codeTo, double rate, LocalDate date){}
