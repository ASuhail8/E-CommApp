package com.example;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class TestRunner {
    public static void main(String[] args) {
        //TestRunner testRunner = new TestRunner();
        //testRunner.runTestNG();
        org.testng.TestNG.main(args);
    }

    public void testngXmlSuite() {

        List<XmlSuite> suites = new ArrayList<>();
        List<XmlClass> classes = new ArrayList<>();

        XmlSuite suite = new XmlSuite();
        suite.setName("MyTestSuite");

        XmlTest xmlTest = new XmlTest();
        xmlTest.setName("MyTest");

        XmlClass xmlClass = new XmlClass("com.example.GoogleTest");
        classes.add(xmlClass);

        xmlTest.setXmlClasses(classes);

        suites.add(suite);

        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);
        testNG.run();


    }

    public void runTestNG(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("main-testng.xml");//path to xml..
        //suites.add(System.getProperty("testngXmlFile"));
        testng.setTestSuites(suites);
        testng.run();
    }
}
