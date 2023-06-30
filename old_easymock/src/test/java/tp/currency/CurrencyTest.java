package tp.currency;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.easymock.EasyMock;
import org.junit.Test;

//NB: this example is based on wikipedia
public class CurrencyTest /*extends TestCase*/ {

	@Test
    public void testToEuros() throws IOException {
        Currency testObjectUSD = new Currency(2.50, "USD");
        Currency testObjectGBP = new Currency(2.00, "GBP");
    
        //1. PREPARE MOCK of ExchangeRate :
        ExchangeRate mock = EasyMock.createMock(ExchangeRate.class);
        //1.1 record/register all the desired fake/mocked behavior:
        EasyMock.expect(mock.getRate("USD", "EUR")).andReturn(1.5); 
        EasyMock.expect(mock.getRate("GBP", "EUR")).andReturn(1.1); 
        //1.2 replay/activate all registered behavior 
        EasyMock.replay(mock); 
        
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
        //EasyMock.verify(mock);
    }

}
