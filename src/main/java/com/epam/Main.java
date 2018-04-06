package com.epam;

import com.epam.runner.CliParser;
import com.epam.tests.OnlinerTest;
import org.apache.commons.cli.ParseException;
import org.testng.TestNG;
import org.testng.xml.SuiteXmlParser;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        XmlSuite suite = new XmlSuite();
        suite.setName("VirtualSuite");

        XmlTest test = new XmlTest(suite);
        test.setName("ChromeFrameTest");
        List<XmlClass> classes = new ArrayList<XmlClass>();

        classes.add(new XmlClass(OnlinerTest.class));
        test.setXmlClasses(classes);

        /*String file = "src/main/resources/testng.xml";
        SuiteXmlParser parser = new SuiteXmlParser();
        XmlSuite suite = parser.parse(file, new FileInputStream(file), true);*/

        List<XmlSuite> suitesList = new ArrayList<>();
        try {
            suitesList.add(CliParser.suiteManage(suite, args));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TestNG tng = new TestNG();
        tng.setXmlSuites(suitesList);
        tng.run();
    }
}
