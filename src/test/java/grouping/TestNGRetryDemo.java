package grouping;

import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.RetryAnalyzer;

public class TestNGRetryDemo {
	
	@Test
	public void test1()
	{
		System.out.println("In test 1");
	}
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class )
	public void test2()
	{
		System.out.println("In test 2");
		Assert.assertTrue(0>1);
	}
	@Test
	public void test3()
	{
		System.out.println("In Test 3");
	}
	
	

}
