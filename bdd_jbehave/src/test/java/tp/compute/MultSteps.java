package tp.compute;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class MultSteps {
	private ContextualComputing contextualComputing = new ContextualComputing();

    @Given("initialCtxValue=$a")
    public void initContextValue(double a) {
    	contextualComputing.setValue(a);
    }

    @When("multiplyBy=$b")
    public void lorsqueMultPar(double b) {
    	contextualComputing.multiplyBy(b);
    }
    
    @Then("expectedCtxValue=$val")
    public void verifNewCtxValue(double val) {
       assertEquals(val,contextualComputing.getValue(),0.0001) ;
    }
}
