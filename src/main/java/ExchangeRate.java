import es.ulpgc.moneycalulator.model.Currency;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, double rate, LocalDate date){}
