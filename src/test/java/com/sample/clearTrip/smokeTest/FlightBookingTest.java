package com.sample.clearTrip.smokeTest;

import org.testng.annotations.Test;
import com.sample.clearTrip.BaseTest;

import java.util.HashMap;
import java.util.Map;

public class FlightBookingTest extends BaseTest {

    @Test (priority = 1)
    public void testThatResultsAppearForAOneWayJourney() {
    	logger.info("testThatResultsAppearForAOneWayJourney test started!");
        Map<String, Integer> passengerList = new HashMap<String, Integer>();
        passengerList.put("adult",1);
        navigator.searchOneWayFlight("Bangalore", "Delhi", "12/6/2018", passengerList);
        //All these details can be read from excel //TODO
        logger.info("testThatResultsAppearForAOneWayJourney test executed successfully!");
    }

}
