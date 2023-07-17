package iRetryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	/*This example shows that failed test case will run 3 times till it passes. 
	 * In case it fails the third time, test execution will stop and TestNG will mark this case as failed. 
	 * We can change the number of tries by changing the value of maxRetryCount.*/

	int retryCount = 0;
	int maxRetryCount = 2;

	public boolean retry(ITestResult result) {

		if (!result.isSuccess()) { // Check if test is failed

			if (retryCount < maxRetryCount) { // Check if the maximum number of test execution is reached
				System.out.println(
						"Retrying Test : Re-running " + result.getName() + " for " + (retryCount + 1) + " time(s)."); 
				
				// Print the number of Retry attempts

				retryCount++; // Increase the maxRetryCount by 1

				result.setStatus(ITestResult.FAILURE); // Mark test as failed
				return true; // Rerun the failed test
			} else {
				result.setStatus(ITestResult.FAILURE); // TestNG marks last run as failed, if last run is max retry
			}
		} else {
			result.setStatus(ITestResult.SUCCESS); // TestNG parks test as passed when the test test passes

		}

		return false;
	}
}