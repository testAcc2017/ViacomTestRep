package com.epam.runner;


import org.apache.commons.cli.*;
import org.testng.xml.XmlSuite;

import java.util.HashMap;
import java.util.Map;

public class CliParser {
    private static final int THREADCOUNT = 3;
    private static String browser = "firefox";
    private static String platform = "WIN10";
    private static boolean retry = true;

    public static String getBrowser() {
        return browser;
    }

    private static void setBrowser(String browser) {
        CliParser.browser = browser;
    }

    public static String getPlatform() {
        return platform;
    }

    private static void setPlatform(String platform) {
        CliParser.platform = platform;
    }

    public static boolean isRetry() {
        return retry;
    }

    private static void setRetry(boolean retry) {
        CliParser.retry = retry;
    }

    public static XmlSuite suiteManage(XmlSuite suite, String[] args) throws ParseException {
        Map<String, String> parameters = new HashMap<String, String>();
        CommandLineParser CLIparser = new DefaultParser();
        CommandLine cmd = CLIparser.parse(optionsSet(), args);
        if (cmd.hasOption("thread")) {
            suite.setThreadCount(Integer.parseInt(cmd.getOptionValue("thread")));
        } else suite.setThreadCount(THREADCOUNT);
        if (cmd.hasOption("browser")) {
            //setBrowser(cmd.getOptionValue("browser"));
            parameters.put("browser", cmd.getOptionValue("browser"));
        }
        if (cmd.hasOption("platform")) {
            //setPlatform(cmd.getOptionValue("platform"));
            parameters.put("platform", cmd.getOptionValue("platform"));
        }
        if (cmd.hasOption("retry")) {
            if (cmd.getOptionValue("retry").equalsIgnoreCase("true") ||
                    cmd.getOptionValue("retry").equals("1")) {
                setRetry(true);
            }
        } else setRetry(false);
        suite.setParameters(parameters);
        return suite;
    }

    private static Options optionsSet() {
        Options options = new Options();
        options.addOption("t", "thread", false, "counts of threads");
        options.addOption("b", "browser", true, "set the browser");
        options.addOption("p", "platform", true, "set the platform");
        options.addOption("r", "retry", false, "retry fail tests");
        return options;
    }

}
