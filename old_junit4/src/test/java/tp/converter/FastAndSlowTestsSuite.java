package tp.converter;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tp.converter.categories.SecondaryTests;
import tp.converter.categories.SlowTests;

@RunWith(Categories.class)//à la place de @RunWith(Suite.class)
//@Categories.ExcludeCategory({NotFinishedTests.class})
@Suite.SuiteClasses({
	TestWithCategory.class ,
	TestWithAssumptions.class
})
public class FastAndSlowTestsSuite  {
}
