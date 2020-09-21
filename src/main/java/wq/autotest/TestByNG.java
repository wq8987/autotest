package wq.autotest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 
 * @author WangQiang testNg特性: 依赖性测试 测试分组 参数化测试
 *         设置多线程属性运行测试用例eg:@Test(threadPoolSize = 3, invocationCount = 5,
 *         timeOut = 1000, groups = { "multiple" }) 分布式测试特性 重新运行前次运行失败的测试用例
 *
 *
 */
public class TestByNG {
	
	@DataProvider(name = "testParam")
    public static String[][] primeNumbers() {
        return new String[][]{
        		{"aa","bb"},
        		{"cc","dd"},
        		{"ee","ff"}
        };
    }

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}

	@BeforeGroups
	public void beforeGroups() {
		System.out.println("just run as beforeGroups");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@Test(groups={"tests1"})
	public void test1_0() {
		System.out.println("test1_0");
	}

	@Test(groups={"tests1"},dependsOnMethods={ "test1_0" })
	public void test1_1() {
		System.out.println("test1_1");
	}
	
	@Test(groups={"tests2"},dependsOnMethods={ "test1_1","test2_1" })
	public void test2_0() {
		System.out.println("test2_0");
	}
	
	@Test(groups={"testParam"},dataProvider="testParam")
	public void testParam(String name,String value) {
		System.out.println("testParam-start");
		System.out.println("name=" + name + ",value=" + value);
		System.out.println("testParam-end");
	}

	@Test(groups={"tests2"})
	public void test2_1() {
		System.out.println("test2_1");
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("AfterTest");
	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod");
	}

	@AfterClass
	public static void AfterClass() {
		System.out.println("AfterClass");
	}

	@AfterGroups
	public void AfterGroups() {
		System.out.println("just run as AfterGroups");
	}

	@AfterSuite
	public void AfterSuite() {
		System.out.println("AfterSuite");
	}

}
