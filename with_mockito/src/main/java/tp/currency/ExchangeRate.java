package tp.currency;

import java.io.IOException;

public interface ExchangeRate {
	double getRate(String inputCurrency, String outputCurrency) throws IOException;
}
