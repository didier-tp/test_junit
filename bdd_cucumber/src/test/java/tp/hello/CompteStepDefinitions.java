package tp.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tp.bank.Compte;


public class CompteStepDefinitions {
	private static Logger logger = LoggerFactory.getLogger(CompteStepDefinitions.class);
	
	//before implementation:
	//throw new io.cucumber.java.PendingException();

	private Compte compte=null;
	private Boolean avecException =false;
	
	

    @Given("soldeInitial={double}")
    public void given_soldeInitial(double soldeInitial) {
        this.compte = new Compte(1L,"compte_1" , soldeInitial);
        logger.trace("given_soldeInitial="+soldeInitial + " compte="+compte);
    }

    @When("debiter montant={double}")
    public void when_debiter(double montant) {
    	logger.trace("when_debiter montant="+montant );
        try {
			this.compte.debiter(montant);
			this.avecException=false;
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			this.avecException=true;
			//e.printStackTrace();
		}
    }

    @Then("nouveauSolde={double}")
    public void then_nouveauSolde(Double expectedNouveauSolde) {
        assertEquals(expectedNouveauSolde, compte.getSolde());
        logger.trace("then_nouveauSolde="+compte.getSolde() );
    }
    
    //@And or @Then
    @Then("statut={string}")
    public void and_status_is(String expectedStatus) {
        assertEquals(expectedStatus, compte.getStatut().toString());
    }
    
    
    @ParameterType(value = "true|True|TRUE|false|False|FALSE")
	public Boolean booleanValue(String value) {
	    return Boolean.valueOf(value);
	}
    
    //@And or @Then
    @Then("AvecException={booleanValue}")
    public void and_AvecException_is(Boolean expectedAvecException) {
        assertEquals(expectedAvecException, avecException);
    }


}
