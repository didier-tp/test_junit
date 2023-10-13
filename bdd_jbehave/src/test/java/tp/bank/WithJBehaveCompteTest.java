package tp.bank;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WithJBehaveCompteTest extends JUnitStories {
	
	private static Logger logger = LoggerFactory.getLogger(WithJBehaveCompteTest.class);

	
	@Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
          .useStoryLoader(new LoadFromClasspath(this.getClass()))
          .useStoryReporterBuilder(new StoryReporterBuilder()
           .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
           .withFormats(Format.CONSOLE /*, Format.HTML*/)
           );
    }

	@Override
	public List<String> storyPaths() {
		//logger.trace("**** tp/bank/compte.story");
		return Arrays.asList("tp/bank/compte.story");//si compte.story placé dans src/main/resources/tp/bank
	}
	
	@Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new CompteSteps());
    }

}
