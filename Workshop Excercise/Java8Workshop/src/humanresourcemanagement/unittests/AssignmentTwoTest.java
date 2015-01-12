package humanresourcemanagement.unittests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static humanresourcemanagementdemo.WorkShopAssignment.getTotalAgeOfAllHumansWithStreams;
import static humanresourcemanagementdemo.WorkShopAssignment.sortAllHumansWithStreams;
import static humanresourcemanagementdemo.WorkShopAssignment.getAllHumansOlderThan20WithStreams;
import static humanresourcemanagementdemo.WorkShopAssignment.getTotalAgeOfAllHumansUnder30WithStreams;
import static humanresourcemanagementdemo.WorkShopAssignment.getACertainPersonWithNestedStreams;

import static humanresourcemanagement.WorkShopAnswers.getTotalAgeOfAllHumans;
import static humanresourcemanagement.WorkShopAnswers.sortWithStreams;
import static humanresourcemanagement.WorkShopAnswers.getHumansOver20;
import static humanresourcemanagement.WorkShopAnswers.getHermanSales;
import static humanresourcemanagement.WorkShopAnswers.getTotalAgeOfAllHumansUnder30;


import humanresourcemanagement.data.HumanXmlAdapter;
import humanresourcemanagement.humans.HumansCollection;

public class AssignmentTwoTest {
	
	HumansCollection testCollection;
	
	@Before
    public void setUp() throws Exception {
		HumanXmlAdapter dataSource = new HumanXmlAdapter("data/humans.xml");
        testCollection = new HumansCollection(dataSource.getAllHumans());
    }

    @Test
    public void shouldSortAllHumansWithStreams() {
        assertEquals(sortAllHumansWithStreams(testCollection), sortWithStreams(testCollection));
    }

    @Test
    public void shouldGetAllHumansOlderThan20WithStreams() {
    	assertEquals(getAllHumansOlderThan20WithStreams(testCollection), getHumansOver20(testCollection));
    }

    @Test
    public void shouldGetTotalAgeOfAllHumansUnder30WithStreams() {
    	assertEquals(getTotalAgeOfAllHumansUnder30WithStreams(testCollection), getTotalAgeOfAllHumansUnder30(testCollection));
    }

    @Test
    public void shouldGetTotalAgeOfAllHumansWithStreams() {
    	assertEquals(getTotalAgeOfAllHumansWithStreams(testCollection), getTotalAgeOfAllHumans(testCollection));
    }

    @Test
    public void shouldGetACertainPersonWithNestedStreams() {
    	String[] s = {"Herman Sales", "m"};
    	assertEquals(getACertainPersonWithNestedStreams(testCollection, s),getHermanSales(testCollection, s));
    }
}
