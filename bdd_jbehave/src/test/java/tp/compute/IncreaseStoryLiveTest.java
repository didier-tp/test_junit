package tp.compute;

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

public class IncreaseStoryLiveTest extends JUnitStories {

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
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new IncreaseSteps());
    }

    @Override
	public List<String> storyPaths() {
        return Arrays.asList("tp/compute/increase.story");
    }

}
