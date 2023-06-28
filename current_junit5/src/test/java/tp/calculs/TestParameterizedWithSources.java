package tp.calculs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestParameterizedWithSources {
	
	private static Logger logger = LoggerFactory.getLogger(TestParameterizedWithSources.class);
	
	public enum Direction  { NORD , SUD, EST , OUEST  }
	
	@ParameterizedTest
	  @ValueSource(ints = { 1, 2, 3 })
	 void testParametreAvecIntValueSource(int valeur) {
		double valPlusVal = valeur + valeur;
		double doubleDeVal = valeur * 2;
	    assertEquals(valPlusVal, doubleDeVal);
	    logger.trace("testParametreAvecIntValueSource valeur="+valeur 
	    		     + " valPlusVal=" + valPlusVal + " doubleDeVal=" + doubleDeVal);
	  }
	
	@ParameterizedTest
	  @ValueSource(strings = { "un", "deux" })
	 void testParametreAvecStringValueSource(String valeur) {
		String valMin = valeur.toLowerCase();
		String valMaj = valeur.toUpperCase();
	    assertTrue( valMin.equalsIgnoreCase(valMaj) );
		logger.trace("testParametreAvecStringValueSource valeur="+valeur 
   		     + " valMin=" + valMin + " valMaj=" + valMaj);
	  }
	
	@ParameterizedTest
	  @MethodSource("fournirDonneesParametres")
	  void testTraiterSelonMethodSource(String element) {
	    assertTrue(element.startsWith("elt"));
		logger.trace("testTraiterSelonMethodSource element="+element);
	  }


	  static Stream<String> fournirDonneesParametres() {
	    return Stream.of( "elt1" , "elt2" );
	  }
	  
	  @ParameterizedTest
	  @EnumSource(TestParameterizedWithSources.Direction.class)
	  void testTraiterSelonEnumValues(Direction direction) {
		assertTrue(direction.toString().length()>=3);
		logger.trace("testTraiterSelonEnumValues direction="+direction);
		
	  }
	  
	  @ParameterizedTest
	  @CsvSource(delimiter = ';', 
	     value= { "1;1;un" , 
	    		  "2;4;quatre" , 
	    		  "3;9;neuf"
	  			}
	  )
	  void testTraiterSelonCsvSource(int n,int expectedCarre,String comment) {
		assertTrue(n*n == expectedCarre);
		logger.trace("testTraiterSelonCsvSource n="+n 
				     + " expectedCarre="+expectedCarre
				     + " comment="+comment);
		
	  }
	  
	  @ParameterizedTest
	  @CsvFileSource( resources= "/carres.csv", delimiter = ';', numLinesToSkip = 1)
	  //files= "carres.csv" found at eclipse project root
	  //resources= "/carres.csv" found in src/test/resources
	  void testTraiterSelonCsvFileSource(int n,int expectedCarre,String comment) {
		assertTrue(n*n == expectedCarre);
		logger.trace("testTraiterSelonCsvFileSource n="+n 
				     + " expectedCarre="+expectedCarre
				     + " comment="+comment);
		
	  }
	  
	  /* content of src/test/resources :
		n;carre;comment
		1;1;un 
		2;4;quatre 
		3;9;neuf
	   */

}
