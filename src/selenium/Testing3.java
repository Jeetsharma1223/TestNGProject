package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	
	SoftAssert softAssert = new SoftAssert();

	@Test(priority = 1)
	public void homeTest() {
		System.out.println("I am in home test");
		System.out.println("Before assertion");
		Assert.assertTrue(4>3, "Verifying Element");
		System.out.println("After assertion");
		Assert.assertEquals("abc", "abc");
	}
	
	@Test(priority = 2, dependsOnMethods="homeTest", groups = {"smoke","sanity"})
	public void mainTest() {
		System.out.println("I am in main test");
		System.out.println("Before assertion");
		softAssert.assertTrue(2>3, "Verifying Element");
		System.out.println("After assertion");
		softAssert.assertAll(); // similar to error collector
	}
	
	@Test(priority = 3, dependsOnMethods="mainTest", groups ="jeet")
	public void endTest() {
		System.out.println("I am in end test");
		System.out.println("Before assertion");
		softAssert.assertTrue(2>3, "Verifying Element");
		System.out.println("After assertion");
		softAssert.assertEquals("abc", "abc1");
		System.out.println("After Second Assertion");
		softAssert.assertAll(); // similar to error collector
	}
}
