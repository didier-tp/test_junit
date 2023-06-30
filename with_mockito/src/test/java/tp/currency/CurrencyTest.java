package tp.currency;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;



//NB: this example is based on wikipedia
public class CurrencyTest /*extends TestCase*/ {

	@Test
    public void testToEuros() throws IOException {
        Currency testObjectUSD = new Currency(2.50, "USD");
        Currency testObjectGBP = new Currency(2.00, "GBP");
    
        //1. PREPARE MOCK of ExchangeRate :
        ExchangeRate mock = Mockito.mock(ExchangeRate.class);
        //1.1 record/register all the desired fake/mocked behavior:
        Mockito.when(mock.getRate("USD", "EUR")).thenReturn(1.5); 
        Mockito.when(mock.getRate("GBP", "EUR")).thenReturn(1.1); 
      
        
        //2. call method to test ".toEuros()" with mock 
        Currency actualFromUSD = testObjectUSD.toEuros(mock);
        Currency actualFromGBP = testObjectGBP.toEuros(mock);
        
        //3. CHECK/VERIFY good result (2.50 * 1.5 = 3.75 et 2.0 * 1.1 = 2.2)
        Currency expectedFromUSD = new Currency(3.75, "EUR");
        Currency expectedFromGBP = new Currency(2.2, "EUR");
        //3.1 basic assertion
        assertEquals(expectedFromUSD, actualFromUSD);
        assertEquals(expectedFromGBP, actualFromGBP);
        //3.2 optionaly verify calls made on mock
        Mockito.verify(mock , times(2)).getRate(any(),any());
    }

}
