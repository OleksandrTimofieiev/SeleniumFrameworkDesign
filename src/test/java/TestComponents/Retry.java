package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//Allows us to retry a failed test a desired number of times
public class Retry implements IRetryAnalyzer {

    int count = 0;
    int matchTry = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (count<matchTry) {
            count++;
            return true;
        }
        return false;
    }
}
