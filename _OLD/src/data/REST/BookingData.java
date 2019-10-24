package data.REST;

import rest.API;

public class BookingData implements data.BookingData {

    @Override
    public String getBooking(int bookingId) {

        // Call the API
        return API.getJson(Constants.URL + "/booking/getbooking/" + bookingId);
    }

    @Override
    public String getAllBookings() {

        // Call the API
        return API.getJson(Constants.URL + "/booking/getallbookings");
    }
}
