package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Booking;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BookingDB {

    private Gson gson;
    private BookingData bookingData;

    // Constructor
    public BookingDB(BookingData bookingData) {

        this.bookingData = bookingData;
    }

    /**
     * Retrieve Booking Json and return Booking object
     * @param bookingId - id of the Booking
     * @return Booking object
     */
    public Booking getBooking(int bookingId) {

        gson = new Gson();
        String jsonData = this.bookingData.getBooking(bookingId);
        System.out.println("jsonData: " + jsonData);
        return gson.fromJson(jsonData, Booking.class);

    }

    /**
     * Retrieve BookingList json and return ArrayList<Booking> object
     * @return list of all Bookings in database
     */
    public ArrayList<Booking> getBookingList() {

        gson = new Gson();
        String jsonData = this.bookingData.getAllBookings();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<Booking>>() {}.getType();
        return gson.fromJson(jsonData, type);
    }

//    /**
//     * INSERT a new Booking in the database
//     * @param customer to insert
//     * @return message of success/failure
//     */
//    public String insertBooking(Booking customer) {
//
//        // CustomerId must be 0 for an INSERT to be successful
//        customer.setCustomerId(0);
//
//        gson = new Gson();
//        String jsonData = gson.toJson(customer, Booking.class);
//        String response = this.bookingData.insertBooking(jsonData);
//        return response;
//    }
//
//    /**
//     * UPDATE a Booking in the database
//     * @param oldBooking to check for optimistic concurrency
//     * @param newBooking to update
//     * @return message of success/failure
//     */
//    public String updateBooking(Booking oldBooking, Booking newBooking) {
//
//        gson = new Gson();
//        ArrayList<Booking> list = new ArrayList<>();
//        list.add(oldBooking);
//        list.add(newBooking);
//        Type type = new TypeToken<List<Booking>>() {}.getType();
//
//        String jsonData = gson.toJson(list, type);
//        String response = this.bookingData.updateBooking(jsonData);
//        return response;
//    }
//
//    /**
//     * DELETE an Booking in the database
//     * @param bookingId of Booking to delete
//     * @return message of success/failure
//     */
//    public String deleteBooking(int bookingId) {
//
//        return this.bookingData.deleteBooking(bookingId);
//    }

}
