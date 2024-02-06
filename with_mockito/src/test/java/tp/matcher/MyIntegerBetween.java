package tp.matcher;

/* 
 * NB: old org.mockito.Matchers are now deprecated
 *     use org.mockito.ArgumentMatcher instead
 *     NB: La majorité des matchers pour mockito devraient être de type org.mockito.ArgumentMatcher
 *         il existe cependant org.mockito.hamcrest.MockitoHamcrest.argThat permettant d'utiliser des matcher de hamcrest
 *         mais c'est s'écarter du chemin principal ...
 */

import org.mockito.ArgumentMatcher;

public class MyIntegerBetween implements ArgumentMatcher<Integer>{
	private int inclusiveMini;
	private int inclusiveMaxi;
	
	
	public MyIntegerBetween(int inclusiveMini, int inclusiveMaxi) {
		this.inclusiveMini = inclusiveMini;
		this.inclusiveMaxi = inclusiveMaxi;
	}
	
	public MyIntegerBetween() { 
		this(0,100); //default min max values
	}
	
	@Override
	public boolean matches(Integer  v) {
	   return (v>= inclusiveMini && v <= inclusiveMaxi) ;
	}
	

}