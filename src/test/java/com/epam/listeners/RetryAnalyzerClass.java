package com.epam.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerClass implements IRetryAnalyzer {

    private static final int retryLimit = 2;
    private int counter = 0;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter <= retryLimit)
        {
            counter++;
            return true;
        }
        return false;
    }
}
