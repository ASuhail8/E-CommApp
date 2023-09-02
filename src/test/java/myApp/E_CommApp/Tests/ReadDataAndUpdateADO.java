package myApp.E_CommApp.Tests;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataAndUpdateADO {

    public Object[][] dp1() {
        return new Object[][] {
                new Object[] { "a", "b" },
                new Object[] { "c", "d" },
        };
    }

    public Object[][] dp2() {
        return new Object[][] {
                new Object[] { "e", "f" },
                new Object[] { "g", "h" },
        };
    }

//      @DataProvider
//      public Object[][] dp() {
//        List<Object[]> result = Lists.newArrayList();
//        result.addAll(Arrays.asList(dp11()));
//        result.addAll(Arrays.asList(dp22()));
//        return result.toArray(new Object[result.size()][]);
//      }

//      @Test(dataProvider = "dp")
//      public void f(String a, String b) {
//        System.out.println("f " + a + " " + b);
//      }

//    @DataProvider
//    public Object[][] getAllData() {
//        Object[][] dealers = dp1();
//        Object[][] parts = dp2();
//        return new Object[][] {dealers,parts};
//    }
    public ArrayList<String> partsData() {

        ArrayList<String> parts = new ArrayList<String>();
        parts.add("part1");
        parts.add("part2");
        parts.add("part3");
        parts.add("part4");
        parts.add("part5");
        parts.add("part6");
        parts.add("part11");
        parts.add("part8");
        parts.add("part10");

        return parts;
    }

    public ArrayList<String> dealersData() {

        ArrayList<String> dealers = new ArrayList<String>();
        dealers.add("dealer1");
        dealers.add("dealer2");
        dealers.add("dealer3");

        return dealers;
    }

    @Test(dataProvider = "dp22")
    public void dealer1Test(String parts) {
        LinkedHashMap<String, String> lhm = readHashMapPartsAndTestId();
        System.out.println("launch browser");
        System.out.println("Enter PCC");
        System.out.println("Select dealer 1 ");
        System.out.println("Search for part " + parts);
        if (parts.contains("7") || parts.contains("5")) {
            System.out.println("Call the API to pass the test case with PASSED testcaseId " + lhm.get(parts));
        } else {
            System.out.println("Call the API to pass the test case with FAILED testcaseId " + lhm.get(parts));
            Assert.fail();
        }
    }

    public LinkedHashMap<String, String> readHashMapPartsAndTestId() {
        ArrayList<String> parts = readParts();
        ArrayList<String> testIds = readTestIds();
        LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();
        for (int i = 0; i < parts.size(); i++) {
            hm.put(parts.get(i), testIds.get(i));
        }
        return hm;
    }

    @Test(dataProvider = "dp22")
    public void dealer2Test(String parts) {
        System.out.println("Select dealer 2 ");
        System.out.println("Enter PCC");
        System.out.println("launch browser");
        System.out.println("Search for part " + parts);
        System.out.println("update test case of part " + parts);
    }

    @Test(dataProvider = "dp22")
    public void print(String parts) {

        System.out.println(parts);

    }

    public ArrayList<String> readTestIds() {
        ArrayList<String> testIds = new ArrayList<String>();
        testIds.add("7");
        testIds.add("8");
        testIds.add("9");
        testIds.add("10");
        testIds.add("11");
        testIds.add("12");
        testIds.add("13");
        testIds.add("14");
        testIds.add("15");
        testIds.add("16");
        return testIds;
    }

    public ArrayList<String> readParts() {
        ArrayList<String> parts = new ArrayList<String>();
        parts.add("part1");
        parts.add("part2");
        parts.add("part3");
        parts.add("part4");
        parts.add("part5");
        parts.add("part6");
        parts.add("part7");
        parts.add("part8");
        parts.add("part9");
        parts.add("part10");
        return parts;
    }

    @DataProvider
    public Object[][] dp22() {
        ArrayList<String> parts = readParts();

        Object objArray[][] = new Object[parts.size()][];
        for (int i = 0; i < parts.size(); i++) {
            objArray[i] = new Object[1];
            objArray[i][0] = parts.get(i);
        }
        return objArray;
    }

    /*
     * @DataProvider
     * public Object[][] getData4() {
     * 
     * ArrayList<String> dealers = new ArrayList<String>();
     * dealers.add("dealer1");
     * dealers.add("dealer2");
     * dealers.add("dealer3");
     * dealers.add("dealer4");
     * dealers.add("dealer5");
     * dealers.add("dealer6");
     * dealers.add("dealer7");
     * dealers.add("dealer8");
     * dealers.add("dealer9");
     * dealers.add("dealer10");
     * 
     * ArrayList<String> parts = new ArrayList<String>();
     * parts.add("part1");
     * parts.add("part2");
     * parts.add("part3");
     * parts.add("part4");
     * parts.add("part5");
     * parts.add("part6");
     * parts.add("part7");
     * parts.add("part8");
     * parts.add("part9");
     * parts.add("part10");
     * 
     * ArrayList<String> testids = new ArrayList<String>();
     * testids.add("TestId1");
     * testids.add("TestId2");
     * testids.add("TestId3");
     * testids.add("TestId4");
     * testids.add("TestId5");
     * testids.add("TestId6");
     * testids.add("TestId7");
     * testids.add("TestId8");
     * testids.add("TestId9");
     * testids.add("TestId10");
     * return null;
     * 
     * 
     * }
     */

}
