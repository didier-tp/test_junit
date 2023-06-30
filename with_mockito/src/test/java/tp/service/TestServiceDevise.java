package tp.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.dao.DaoDevise;
import tp.entity.Devise;
import tp.exception.NotFoundException;

//@RunWith(MockitoJUnitRunner.class) //for JUnit 4
//@ExtendWith(MockitoExtension.class) //for JUnit 5
public class TestServiceDevise {

	//QUOI, des Mocks presque partout, mais de qui se moque-t-on ?
	
	private static Logger logger = LoggerFactory.getLogger(TestServiceDevise.class);

		@InjectMocks
		/* @InjectMocks pour demander à "Mockito" de :
	        - créer une instance normale de cette classe (ici new ServiceDeviseImpl(...))
	        - d'injecter le ou les @Mock(s) de cette classe de test dans la classe ServiceDeviseImpl() 
	        via un constructeur adéquat ou via un autre moyen (introspection ou ...)
	   */
		private ServiceDeviseImpl serviceDevise; 
	             //à partiellement tester d'un point de vue purement algorithmique 
		 
		
		@Mock /* @Mock pour demander à "Mockito" de :
		       - créer ultérieurement un Mock de l'interface 
		       - NB: il faudra appeler MockitoAnnotations.openMocks(this); 
	           pour initialiser tous les mocks de this préfixés par @Mock
		     */
		private DaoDevise daoDeviseMock; //mock à utiliser
		
       
		//INUTILE SI EQUIVALENT AU SEIN DE @ExtendWith(MockitoExtension.class)
		@BeforeEach
		public void reInitMock() {
			//Mockito.initMocks(this); in old Junit 4
			MockitoAnnotations.openMocks(this); //with JUnit5/Jupiter
			// MockitoAnnotations.openMocks(this) permet de créer des instances de chaque mock 
			//   préfixé par @Mock au sein de this .
			//   ce qui revient au même que d'écrire :
			//      this.daoDeviseMock = Mockito.mock(RepositoryDevise.class);
			//      this.mock2=Mockito.mock(Interface_ouClasse2.class);
			//      s'il n'y avait pas d'utilisation de @Mock 
		}
	
		
		@Test
		public void testConvertir() {
			double montant=100;
			String codeDeviseSource="EUR";
			String codeDeviseCible="USD";
			double montantConverti=-1;
			//1.préparation du mock en arrière plan:
			Mockito.when(daoDeviseMock.findByCode(codeDeviseSource))
			      	 .thenReturn(new Devise("EUR","Euro",1.0));
			Mockito.when(daoDeviseMock.findByCode(codeDeviseCible))
		          		 .thenReturn(new Devise("USD","Dollar",1.1));
			//2.appel de la méthode convertir sur le service et test retour
			montantConverti = serviceDevise.convertir(montant, codeDeviseSource,codeDeviseCible);
			logger.debug("montantConverti="+montantConverti);
			Assertions.assertEquals(montant * 1.1 , montantConverti, 0.000001);
			//3.verif service appelant 2 fois deviseDao.findById() via aspect spy de Mockito:
			Mockito.verify(daoDeviseMock, Mockito.times(2)).findByCode(anyString());
		}	
		
		@Test
		public void testConvertirAvecDeviseInconnue() {
			double montant=100;
			String codeDeviseSource="EUR";
			String codeDeviseCibleInconnu="C??";
			//1.préparation du mock en arrière plan:
			Mockito.when(daoDeviseMock.findByCode(codeDeviseSource))
			       	.thenReturn(new Devise("EUR","Euro",1.0));
			Mockito.when(daoDeviseMock.findByCode(codeDeviseCibleInconnu))
		          		 .thenReturn(null);
			//2.appel de la méthode convertir sur le service et test exception en retour
			try {
			  serviceDevise.convertir(montant, codeDeviseSource,codeDeviseCibleInconnu);
			  Assertions.fail("une exception aurait normalement du remonter");
			}catch(Exception ex) {
				logger.debug("exception normalement attendue="+ex.getMessage());
				Assertions.assertTrue(ex.getClass().getSimpleName().equals("NotFoundException"));
			}
		}
		
		@Test
		public void testConvertirAvecDeviseInconnueV2() {
			double montant=100;
			String codeDeviseSource="EUR";
			String codeDeviseCibleInconnu="C??";
			//1.préparation du mock en arrière plan:
			Mockito.when(daoDeviseMock.findByCode(codeDeviseSource))
			       	.thenReturn(new Devise("EUR","Euro",1.0));
			Mockito.when(daoDeviseMock.findByCode(codeDeviseCibleInconnu))
		          		 //.thenThrow(NotFoundException.class);
			               .thenThrow(new NotFoundException("C?? not found"));
			//2.appel de la méthode convertir sur le service et test exception en retour
			/*
			try {
			  serviceDevise.convertir(montant, codeDeviseSource,codeDeviseCibleInconnu);
			  Assertions.fail("une exception aurait normalement du remonter");
			}catch(Exception ex) {
				logger.debug("exception normalement attendue="+ex.getMessage());
				Assertions.assertTrue(ex.getClass().getSimpleName().equals("NotFoundException"));
			}
			*/
			NotFoundException nfe = assertThrows( NotFoundException.class,()->{
				 serviceDevise.convertir(montant, codeDeviseSource,codeDeviseCibleInconnu);
			});
			logger.debug("exception normalement attendue(V2)="+nfe.getMessage());
		}

}
