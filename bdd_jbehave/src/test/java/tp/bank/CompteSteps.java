package tp.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CompteSteps {
	private static Logger logger = LoggerFactory.getLogger(CompteSteps.class);
	
	private Compte compte=null;
	private Boolean avecException =false;
	

    @Given("soldeInitial=<soldeInitial>")
    public void given_soldeInitial(@Named("soldeInitial")double soldeInitial) {
        this.compte = new Compte(1L,"compte_1" , soldeInitial);
        //logger.trace("given_soldeInitial="+soldeInitial + " compte="+compte);
    }

    @When("debiter montant=<montant>")
    public void when_debiter(@Named("montant")double montant) {
    	//logger.trace("when_debiter montant="+montant );
        try {
			this.compte.debiter(montant);
			this.avecException=false;
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			this.avecException=true;
			//e.printStackTrace();
		}
    }

    @Then("nouveauSolde=<nouveauSolde>")
    public void then_nouveauSolde(@Named("nouveauSolde")Double expectedNouveauSolde) {
        assertEquals(expectedNouveauSolde, compte.getSolde());
        //logger.trace("then_nouveauSolde="+compte.getSolde() );
    }
    

    @Then("statut=<statut>")
    public void and_status_is(@Named("statut") String expectedStatus) {
        assertEquals(expectedStatus, compte.getStatut().toString());
    }
    
    @Then("AvecException=<AvecException>")
    public void and_AvecException_is(@Named("AvecException")Boolean expectedAvecException) {
        assertEquals(expectedAvecException, avecException);
    }


}
