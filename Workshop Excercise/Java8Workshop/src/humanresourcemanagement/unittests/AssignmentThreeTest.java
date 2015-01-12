package humanresourcemanagement.unittests;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import static humanresourcemanagementdemo.WorkShopAssignment.getOptionalFromString;
import static humanresourcemanagementdemo.WorkShopAssignment.getStringFromOptional;
import static humanresourcemanagement.WorkShopAnswers.getOptFromStr;
import static humanresourcemanagement.WorkShopAnswers.getStrFromOpt;


import humanresourcemanagement.data.HumanXmlAdapter;
import humanresourcemanagement.humans.HumansCollection;

public class AssignmentThreeTest {
	
	HumansCollection testCollection;
	
	@Before
    public void setUp() throws Exception {
		HumanXmlAdapter dataSource = new HumanXmlAdapter("data/humans.xml");
        testCollection = new HumansCollection(dataSource.getAllHumans());
    }
	
    @Test
    public void shouldGetOptional() {
        assertEquals(getOptFromStr("test"), getOptionalFromString("test"));
    }
    
    @Test
    public void shouldGetString() {
        assertEquals(getStrFromOpt(Optional.of("test")), getStringFromOptional(Optional.of("test")));
    }
}
