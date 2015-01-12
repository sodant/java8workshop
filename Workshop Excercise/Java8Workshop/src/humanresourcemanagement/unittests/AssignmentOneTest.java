package humanresourcemanagement.unittests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static humanresourcemanagementdemo.WorkShopAssignment.filterMaleAdultsWithStaticMethodReference;
import static humanresourcemanagementdemo.WorkShopAssignment.filterUsingAnonymousInnerClass;
import static humanresourcemanagementdemo.WorkShopAssignment.filterWithLambda;
import static humanresourcemanagementdemo.WorkShopAssignment.filterWithMethodReference;
import static humanresourcemanagementdemo.WorkShopAssignment.sortHumansWithLambda;
import static humanresourcemanagementdemo.WorkShopAssignment.sortWithComparing;

import static humanresourcemanagement.WorkShopAnswers.getAdultsFunctional;
import static humanresourcemanagement.WorkShopAnswers.getAdultsLambda;
import static humanresourcemanagement.WorkShopAnswers.getAdultsMethodReference;
import static humanresourcemanagement.WorkShopAnswers.getMaleAdultsStaticMethodReference;
import static humanresourcemanagement.WorkShopAnswers.sortHumansLambda;
import static humanresourcemanagement.WorkShopAnswers.sortHumansWithComparing;

import humanresourcemanagement.data.HumanXmlAdapter;
import humanresourcemanagement.humans.HumansCollection;

public class AssignmentOneTest {
	
	HumansCollection testCollection;
	
	@Before
    public void setUp() throws Exception {
		HumanXmlAdapter dataSource = new HumanXmlAdapter("data/humans.xml");
        testCollection = new HumansCollection(dataSource.getAllHumans());
    }

    @Test
    public void shouldFilterAdultsWithAnonymousInnerClass() {
        assertEquals(filterUsingAnonymousInnerClass(testCollection), getAdultsFunctional(testCollection));
    }

    @Test
    public void shouldFilterAdultsWithLambda() {
    	assertEquals(filterWithLambda(testCollection), getAdultsLambda(testCollection));
    }

    @Test
    public void shouldFilterAdultsWithMethodReference() {
    	assertEquals(filterWithMethodReference(testCollection), getAdultsMethodReference(testCollection));
    }

    @Test
    public void shouldFilterMaleAdultsWithStaticMethodReference() {
    	assertEquals(filterMaleAdultsWithStaticMethodReference(testCollection), getMaleAdultsStaticMethodReference(testCollection));
    }

    @Test
    public void shouldSorthumanByNameWithLambda() {
    	assertEquals(sortHumansWithLambda(testCollection),sortHumansLambda(testCollection));
    }

    @Test
    public void shouldSorthumanByNameUsingComparatorComparingWithMethodReference() {
    	assertEquals(sortWithComparing(testCollection),sortHumansWithComparing(testCollection));
    }
}
