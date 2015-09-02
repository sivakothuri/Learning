package junit;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

public class Junit1 {

	@Rule
	public ContractRule rule = new ContractRule();
	
	@Test
	public void test() {
		System.out.println("Junit1.test() :" +rule.getRandomNumber());
		fail("Not yet implemented");
	}
	
	@Test
	public void test1() {
		System.out.println("Junit1.test1() :" +rule.getRandomNumber());
	}

	@Before
	public void before() {
		System.out.println("Junit1.before()");
	}

	@After
	public void after() {
		System.out.println("Junit1.after()");

	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Junit1.beforeClass()");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Junit1.afterClass()");

	}

}
