package com.epam.runner;


import org.apache.commons.cli.*;
import org.testng.xml.XmlSuite;

public class CliParser {
    public static XmlSuite suiteManage(XmlSuite suite, String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("thread", true, "counts of threads");
        CommandLineParser CLIparser = new DefaultParser();
        CommandLine cmd = CLIparser.parse(options, args);
        if(cmd.hasOption("thread")) {
            suite.setThreadCount(Integer.parseInt(cmd.getOptionValue("thread")));
        }
        return suite;
    }
}
