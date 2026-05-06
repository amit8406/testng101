package grouping;

import org.testng.annotations.Test;

public class DependsOnDemo {
	@Test(dependsOnMethods={"Test2","Test3"},priority=0)
	public void Test1()
	{
		System.out.println("In test 1 method!");
	}
	
	@Test(priority=3)
	public void Test2()
	{
		System.out.println("In test 2 method!");
	}
	
	@Test(priority=2)
	public void Test3()
	{
		System.out.println("In test 3 method!");
	}

}
