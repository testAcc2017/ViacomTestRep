package com.epam.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("Suite " + iSuite.getName() + " is started.");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("Suite " + iSuite.getName() + " is finished.");
    }
}
