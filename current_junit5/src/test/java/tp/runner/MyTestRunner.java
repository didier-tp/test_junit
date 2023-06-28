package tp.runner;



import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.LauncherSession;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import static org.junit.platform.engine.discovery.DiscoverySelectors.*;

import tp.converter.WrongTests;

public class MyTestRunner {
	
	public static void main(String[] args) {
		runSomeTests(); //à peaufiner (pas prioritaire).
	}
	
	public static void runSomeTests() {
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
			    .selectors(
			        selectPackage("tp.converter")
			        //selectClass(TestXy.class)
			    )
			   /* .filters(
			        includeClassNamePatterns("Test.*")
			    )*/
			    .build();

			SummaryGeneratingListener listener = new SummaryGeneratingListener();

			try (LauncherSession session = LauncherFactory.openSession()) {
			    Launcher launcher = session.getLauncher();
			    // Register a listener of your choice
			    launcher.registerTestExecutionListeners(listener);
			    // Discover tests and build a test plan
			    TestPlan testPlan = launcher.discover(request);
			    // Execute test plan
			    launcher.execute(testPlan);
			    // Alternatively, execute the request directly
			    //launcher.execute(request);
			}

			TestExecutionSummary summary = listener.getSummary();
			//System.out.println("summary="+summary);
			System.out.println("summary.getTotalFailureCount()="+summary.getTotalFailureCount());
	}

}
