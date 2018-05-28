package com.sample.clearTrip.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sample.clearTrip.BaseTest;
import org.apache.log4j.Logger;

public class HotelBookingTest extends BaseTest {
	
	public HotelBookingTest() {
		logger = Logger.getLogger(this.getClass());
	}

    @Test (priority = 1)
    public void shouldBeAbleToSearchForHotels() {
    	
    	logger.info("shouldBeAbleToSearchForHotels test started!");
    	//TODO read data from excel
    	Assert.assertTrue(navigator.searchHotels("Indiranagar, Bangalore", "03-06-2018", "04-06-2018", "1 room, 2 adults"), "shouldBeAbleToSearchForHotels test failed!");
    	logger.info("shouldBeAbleToSearchForHotels test completed!");
    }

}
