package com.epam.listeners;

import com.epam.runner.CliParser;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int retryLimit = 2;
    private int counter = 0;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (CliParser.isRetry()) {
            if (counter < retryLimit) {
                counter++;
                return true;
            }
        }
        return false;
    }
}
