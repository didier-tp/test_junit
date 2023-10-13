package tp.compute;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class IncreaseSteps {
	private int counter;
    private int previousValue;

    @Given("a counter")
    public void aCounter() {
    }

    @Given("the counter has any random integer value")
    public void counterHasAnyIntegralValue() {
        counter = new Random().nextInt();
        previousValue = counter;
    }

    @When("the user increases the counter")
    public void increasesTheCounter() {
        counter++;//ok
        //counter--;//error
    }

    @Then("the value of the counter must be 1 greater than previous value")
    public void theValueOfTheCounterMustBe1Greater() {
        assertTrue(1 == counter - previousValue);
    }
}
