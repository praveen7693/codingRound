package com.sample.clearTrip.ct.Impl;

import com.sample.clearTrip.ct.Impl.ctPages.FlightsPage;
import com.sample.clearTrip.ct.Navigator;

import java.util.Map;

public class NavigatorImpl implements Navigator {

    public boolean searchOneWayFlight(String startingPoint, String destination, String date, Map<String, Integer> passengerList) {
        return FlightsPage.getInstance().searchOneWayFlight(startingPoint, destination, date, passengerList);
    }

}
