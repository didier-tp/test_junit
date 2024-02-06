package tp.matcher;

/* 
 * NB: old org.mockito.Matchers are now deprecated
 *     use org.mockito.ArgumentMatcher instead
 *     NB: La majorité des matchers pour mockito devraient être de type org.mockito.ArgumentMatcher
 *         il existe cependant org.mockito.hamcrest.MockitoHamcrest.argThat permettant d'utiliser des matcher de hamcrest
 *         mais c'est s'écarter du chemin principal ...
 */

import org.mockito.ArgumentMatcher;

public class MyDoubleBetween implements ArgumentMatcher<Double>{
	private double inclusiveMini;
	private double exclusiveMaxi;
	
	public MyDoubleBetween() { super();
	this.inclusiveMini = 0.0; this.exclusiveMaxi = 100.0;
	}
	
	public MyDoubleBetween(double inclusiveMini, double exclusiveMaxi) {
	super(); 
	this.inclusiveMini = inclusiveMini;
	this.exclusiveMaxi = exclusiveMaxi;
	}
	
	@Override
	public boolean matches(Double  arg0) {
	Double x= (Double) arg0;
	if(x>= inclusiveMini && x < exclusiveMaxi)
	   return true;
	/*else*/
	   return false;
	}
	

}