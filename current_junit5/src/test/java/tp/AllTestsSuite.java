package tp;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

//@RunWith(JUnitPlatform.class) will be deprecated , use @Suite instead
//but @Suite not already supported by some old IDE (ex: ok with eclipse 2023-03)
@Suite
@SelectPackages({"tp.calculs", "tp.converter" })
public class AllTestsSuite {
}
