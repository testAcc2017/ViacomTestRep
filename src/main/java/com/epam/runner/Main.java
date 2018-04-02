package com.epam.runner;

import org.testng.TestNG;
import org.testng.xml.SuiteXmlParser;
import org.testng.xml.XmlSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "testng.xml";
        SuiteXmlParser parser = new SuiteXmlParser();
        XmlSuite suite = parser.parse(file, new FileInputStream(file), true);

        List<XmlSuite> suitesList= new ArrayList<>();
        suitesList.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suitesList);
        tng.run();
    }
}
