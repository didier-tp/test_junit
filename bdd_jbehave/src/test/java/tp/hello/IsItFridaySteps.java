package tp.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IsItFridaySteps {
	
	private static Logger logger = LoggerFactory.getLogger(IsItFridaySteps.class); 
	

	private String today;
    private String actualAnswer;

    @Given("today is <day>")
    public void today_is(@Named("day")String day) {
    	//logger.trace("**given** today="+day);
        this.today = day;
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told <answer>")
    public void i_should_be_told(@Named("answer") String expectedAnswer) {
    	//logger.trace("is_it_friday , for today="+today + " actualAnswer="+actualAnswer + " exceptedAnswer="+ expectedAnswer);
        assertEquals(expectedAnswer, actualAnswer);
    }


}
