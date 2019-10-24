package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Reward;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RewardDB {

    private Gson gson;
    private RewardData data;

    // Constructor
    public RewardDB(RewardData data) {

        this.data = data;
    }

    /**
     * Retrieve Reward Json and return Reward object
     * @param rewardId - id of the Reward
     * @return Reward object
     */
    public Reward getReward(int rewardId) {

        gson = new Gson();
        String jsonData = this.data.getReward(rewardId);
        System.out.println("jsonData: " + jsonData);
        return gson.fromJson(jsonData, Reward.class);

    }

    /**
     * Retrieve RewardList json and return ArrayList<Reward> object
     * @return list of all Rewards in database
     */
    public ArrayList<Reward> getRewardList() {

        gson = new Gson();
        String jsonData = this.data.getAllRewards();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<Reward>>() {}.getType();
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
