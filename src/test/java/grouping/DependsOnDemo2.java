package grouping;

import org.testng.annotations.Test;

public class DependsOnDemo2 {
	@Test(dependsOnGroups = {"sanity.*"})
	public void Test1()
	{
		System.out.println("In test 1 method!");
	}
	
	@Test(groups = {"sanity1"})
	public void Test2()
	{
		System.out.println("In test 2 method!");
	}
	
	@Test(groups = {"sanity2"})
	public void Test3()
	{
		System.out.println("In test 3 method!");
	}

}
