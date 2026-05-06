package listeners;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo2 {
	@Test
	public void test4()
	{
		System.out.println("inside test 4");
	}
	@Test
	public void test5()
	{
		System.out.println("inside test 5");
		fail("Failed intentionally");
	}
	@Test
	public void test6()
	{
		System.out.println("inside test 6");
	}
}
