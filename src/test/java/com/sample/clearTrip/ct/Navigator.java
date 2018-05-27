package com.sample.clearTrip.ct;

import java.util.Map;

public interface Navigator {

    public boolean searchOneWayFlight (String startingPoint, String destination, String date, Map<String, Integer> passengerList);

    public boolean searchHotels (String location, String checkInDate, String checkOutDate, String travellers);
    
}
