package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{
	  public void onTestStart(ITestResult tr) {
		 System.out.println("*******Test Started: "+tr.getName());
	  }	
	  public void onTestFailure(ITestResult tr) {
		  System.out.println("*******Test Failed: "+tr.getName());
	  }

	  
	  public void onTestSkipped(ITestResult tr) {
		  System.out.println("*******Test Skipped: "+tr.getName());
	    
	  }

	  
	  public void onTestSuccess(ITestResult tr) {
		  System.out.println("*******Test is successful: "+tr.getName());
	   
	  }
	  public void onFinish(ITestResult tr){
		  System.out.println("*******Test is finished: "+tr.getName());
	  }

	
	

}
