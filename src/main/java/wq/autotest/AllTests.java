package wq.autotest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AutoTestByJunit.class, TestByJunit.class })
public class AllTests {

}
