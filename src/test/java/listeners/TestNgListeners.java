package listeners;

import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class TestNgListeners implements ITestListener{
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test name is : " + result.getName());
    }
}
