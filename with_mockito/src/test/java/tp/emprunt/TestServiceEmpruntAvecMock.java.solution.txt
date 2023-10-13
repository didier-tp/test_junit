package tp.emprunt;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//******CODE A COMPLETER (EN DEBUT DE TP)******
public class TestServiceEmpruntAvecMock {
	
	private static Logger logger = LoggerFactory.getLogger(TestServiceEmpruntAvecMock.class);
	
	
	private ServiceEmpruntImpl serviceEmprunt; //à tester
	

	private ServiceTauxInteret serviceTauxInteretMock ;//sous service en arrière plan
	

	private ServiceFraisEmprunt serviceFraisEmpruntMock ;//sous service en arrière plan

	
	@Test
	public void testMensualite() {
		//par defaut (selon ServiceTauxInteretImpl) , tauxInteretBce = 3.5% pour 120mois
		//par defaut (selon ServiceTauxInteretImpl) , coeffMarge = 1.01; 
		//et donc tauxInteretBanque = 3.5 * 1.01 = 3,535 % par an
		//et donc mensualite = 990.499
		//...
	}
	
	@Test
	public void testEmprunt() {
		//par defaut (selon ServiceTauxInteretImpl) , tauxInteret = 3.5% pour 120mois
		//par defaut (selon ServiceTauxInteretImpl) , coeffMarge = 1.01; 
		//et donc tauxInteretBanque = 3.5 * 1.01 = 3.535 % par an
		//et donc mensualite = 990.499
		//par defaut (selon ServiceFraisEmpruntImpl) , fraisDossier = 150.0 pour montant = 100000
		//par defaut (selon ServiceFraisEmpruntImpl) , tauxAnnuelFraisAssurance = 0.4%
		//et donc frais_assurance_mensuel= (0.4 /12 /100) * 100000 = 33.3333
		//et donc mensualiteAvecAssurance =  990.499+ 33.3333 = 1023.8323
		//...
	}
	
	@Test
	public void testEmpruntAvecMontantEmprunteTropPetit() {
		
		//NB: si montant emprunt trop petit , le sous service ServiceFraisEmprunt doit remonter une exception
		// de type MontantEmprunteException
		// et le service "serviceEmprunt" doit laisser remonter cette exception 
		//...
		//NB: au sein de l'implémentation actuelle de ServiceEmpruntImpl , calculEmprunt()
		//appel serviceFraisEmprunt.fraisDossierSelonMontant(montant) en premier
		//et laisse l'excption remonter/se_propager
	}
}
