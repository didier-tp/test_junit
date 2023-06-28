package tp.converter;


// assertj is a more recent assertion library than hamcrest 
// better auto-completion with java IDE , more fluent , ...
//with .assertThat()
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//org.junit.jupiter.api.Assertions does not contains .assertThat()
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.data.Personne;

public class TestConverter /* extends TestCase */ {
	
	private static Logger logger = LoggerFactory.getLogger(TestConverter.class);
	
	@Test
	@DisplayName("test de bonne conversion double from String")
	public void testGoodDoubleFromStringConversion() {
		String sx = "12.34";
		double x = BasicConverter.doubleFromString(sx);
		logger.trace("testGoodDoubleToStringConversion ..., x = " + x);
		assertEquals(12.34,x,0.001);
	}
	
	@Test
	public void testBadDoubleToStringConversion() {
			try {
				String sx = "12a.34";
				double x = BasicConverter.doubleFromString(sx);
				fail("NumberFormatException should be raised");
			} catch (NumberFormatException e) {
				logger.trace("NumberFormatException " +  e.getMessage());
				//e.printStackTrace();
				assertTrue(e.getClass().getSimpleName().equals("NumberFormatException"));
			}
		
	}
	
	@Test
	public void testBadDoubleFromStringConversionV2() {
		RuntimeException exception = assertThrows(/*RuntimeException.class*/ NumberFormatException.class,
				()->{ String sx = "12a.34";
					double x = BasicConverter.doubleFromString(sx);
				});
		assertTrue(exception.getMessage().contains("For input string"));
	}
	
	@Test
	public void testPersonneInLowercase() {
		Personne originalPers = new Personne(2L,"Jean" , "Bon" , 172.4);
		Personne p = (Personne) BasicConverter.allPartsInLowercase(originalPers);
		logger.trace("p with allPartsInLowercase = " +  p);
		Personne expectedPers = new Personne(2L,"jean" , "bon" , 172.4);
		assertEquals(expectedPers, p);  //NB: Personne.equals(...) should be implemented .
	}
	
	@Test
	public void testPersonneWithAssertJAssertThat() {
		Personne originalPers = new Personne(2L,"Jean" , "Bon" , 172.4);
		Personne p = (Personne) BasicConverter.allPartsInLowercase(originalPers);
		logger.trace("p with allPartsInLowercase = " +  p);
		assertThat(p.getNom()).isEqualTo("bon"); //.assertThat() of AssertJ
		//org.junit.jupiter.api.Assertions does not contains .assertThat()
	}
	
	@Test
	public void testSameVsEquals() {
		String s1="abc";
		String s1Maj = s1.toUpperCase();
		String s1Ref2 = s1;
		String s2="ABC";
		Assertions.assertSame(s1Ref2,s1);  //teste si s1Ref2 == s1 (references on same object)
		Assertions.assertNotSame(s1Maj,s2);
		Assertions.assertEquals(s1Maj,s2);//teste si s1Maj.equals(s2))
	}
	
	@Test() 
	@Timeout(value = 200 , unit = TimeUnit.MILLISECONDS)
	public void testWithTimeout() {
		try {
			Thread.sleep(100);//ok
			//Thread.sleep(300);//not_ok
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test() 
	public void testWithTimeoutV2() {
		Assertions.assertTimeout(Duration.ofMillis(200), 
				() -> { 
						try {
							Thread.sleep(100);//ok
							//Thread.sleep(300);//not_ok
						} catch (InterruptedException e) {
							System.err.println(e.getMessage());
						}
				});
	}
	
	
}
