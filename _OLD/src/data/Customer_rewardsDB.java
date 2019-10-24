package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Customer_rewards;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Customer_rewardsDB {

    private Gson gson;
    private Customer_rewardsData data;

    // Constructor
    public Customer_rewardsDB(Customer_rewardsData data) {

        this.data = data;
    }

    /**
     * Retrieve Booking Json and return Customer_rewards object
     * @param customer_rewardsId - id of the Booking
     * @return list of Customer_rewards objects
     */
    public Customer_rewards getCustomer_rewards(int customer_rewardsId) {

        gson = new Gson();
        String jsonData = this.data.getCustomer_rewards(customer_rewardsId);
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        return gson.fromJson(jsonData, Customer_rewards.class);

    }

    /**
     * Retrieve Customer_rewards List json and return ArrayList<Customer_rewards> object
     * @return list of all Customer_rewards in database
     */
    public ArrayList<Customer_rewards> getCustomer_rewardsList() {

        gson = new Gson();
        String jsonData = this.data.getAllCustomer_rewards();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<Customer_rewards>>() {}.getType();
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
//        String response = this.data.insertBooking(jsonData);
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
//        String response = this.data.updateBooking(jsonData);
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
//        return this.data.deleteBooking(bookingId);
//    }

}
