package tp.converter;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

//@RunWith(JUnitPlatform.class) will be deprecated , use @Suite instead
//but @Suite not already supported by some old IDE (ex: ok with eclipse 2023-03)
@Suite
//@IncludeTags({"FastTests"})
@ExcludeTags({"SlowTests", "SecondaryTests"})
@SelectClasses({
	TestWithCategoryTag.class ,
	TestWithAssumptions.class
})
public class FastTestsSuite {
}

/*
 NB: possibilité de filter les category/tags au sein de la config maven:
 <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <configuration>
                <properties>
                    <includeTags>FastTests</includeTags>
                </properties>
            </configuration>
  </plugin>
*/
