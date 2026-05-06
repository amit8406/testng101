package parameters;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterSample {
	
	@Test
	@Parameters({"MyName"})
	public void TestName(@Optional("AMIT") String name)
	{
		System.out.println("The Parameter passed is: "+name);
	}

}
