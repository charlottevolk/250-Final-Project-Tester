package finalproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyTester {
    public static void main(String[] args) throws Exception {
        testXml1();
        testXml2();
        testXml3();
        testXml4();
    }

    private static void testXml1() throws Exception{
        System.out.println("----------TESTING test.xml----------");
        SearchEngine searchEngine = new SearchEngine("test.xml");
        searchEngine.crawlAndIndex("www.cs.mcgill.ca");
        searchEngine.assignPageRanks(0.001);
        //the following code only works for xml files given by prof
        for (String url : searchEngine.internet.getVertices()){
            double expectedRank = searchEngine.parser.getPageRank(url);
            double actualRank = searchEngine.internet.getPageRank(url);
            if (Math.abs(expectedRank-actualRank)>0.001){
                System.out.println("Wrong page rank for " + url);
            }
        }
        System.out.println();
    }

    private static void testXml2() throws Exception{
        System.out.println("----------TESTING cs20Links.xml----------");
        SearchEngine searchEngine = new SearchEngine("cs20Links.xml");
        searchEngine.crawlAndIndex("https://cs.mcgill.ca/");
        searchEngine.assignPageRanks(0.001);
        System.out.println();
        ArrayList<String> results = searchEngine.getResults("engineering");
        int count=1;
        for (String result : results){
            System.out.println(count + ". " + result + " Rank: " + searchEngine.internet.getPageRank(result));
            count++;
        }
        System.out.println();
    }

    private static void testXml3() throws Exception {
        System.out.println("----------TESTING cs60Links.xml----------");
        SearchEngine searchEngine = new SearchEngine("cs60Links.xml");
        searchEngine.crawlAndIndex("https://cs.mcgill.ca/");
        searchEngine.assignPageRanks(0.001);
        System.out.println();
        ArrayList<String> results = searchEngine.getResults("search");
        int count=1;
        for (String result : results){
            System.out.println(count + ". " + result + " Rank: " + searchEngine.internet.getPageRank(result));
            count++;
        }
        System.out.println();
    }

    private static void testXml4() throws Exception {
        System.out.println("----------TESTING mcgillWiki.xml----------");
        SearchEngine searchEngine = new SearchEngine("mcgillWiki.xml");
        searchEngine.crawlAndIndex("https://en.wikipedia.org/wiki/McGill_University");
        searchEngine.assignPageRanks(0.001);
        System.out.println();
        ArrayList<String> results = searchEngine.getResults("chemical");
        int count=1;
        for (String result : results){
            System.out.println(count + ". " + result + " Rank: " + searchEngine.internet.getPageRank(result));
            count++;
        }
        System.out.println();
    }
}
