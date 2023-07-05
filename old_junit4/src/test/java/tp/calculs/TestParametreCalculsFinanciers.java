package tp.calculs;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
A Faire en TP :
tester la méthode .mensualite(montant, nbMois, tauxAnnuelPct)
de la classe tp.calculs.CalculsFinanciers

Données correctes (à ajuster) pour test paramétré:
   "nbMois;montant;tauxAnnuelPct;expectedMensualite",
	"24;10000.0;2.5;427.60" , 
	"48;50000.0;3.0;1106.72" , 
	"60;60000;2.0;1051.67" ,
	"120;80000;2.5;754.16
*/

public class TestParametreCalculsFinanciers {
	
	private static Logger logger = LoggerFactory.getLogger(TestParametreCalculsFinanciers.class);
	
	private CalculsFinanciers calculsFinanciers;//à tester
	
	//...
	
	@Test
	public void testTemporaire() {
		logger.trace("testTemporaire");
	}
}
