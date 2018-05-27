package com.sample.clearTrip.ct.Impl;

import com.sample.clearTrip.ct.Impl.ctPages.FlightsPage;
import com.sample.clearTrip.ct.Impl.ctPages.HotelsPage;
import com.sample.clearTrip.ct.Navigator;

import java.util.Map;

public class NavigatorImpl implements Navigator {

	@Override
    public boolean searchOneWayFlight(String startingPoint, String destination, String date, Map<String, Integer> passengerList) {
        return FlightsPage.getInstance().searchOneWayFlight(startingPoint, destination, date, passengerList);
    }

	@Override
	public boolean searchHotels(String location, String checkInDate, String checkOutDate,
			String travellers) {
		return HotelsPage.getInstance().searchHotels(location, checkInDate, checkOutDate, travellers);
	}

}
