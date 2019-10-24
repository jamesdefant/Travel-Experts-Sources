package data.REST;

import rest.API;

public class Customer_rewardsData implements data.Customer_rewardsData {
    @Override
    public String getCustomer_rewards(int customer_rewardsId) {

        // Call the API
        return API.getJson(Constants.URL + "/customer_rewards/getcustomer_rewards/" + customer_rewardsId);    }

    @Override
    public String getAllCustomer_rewards() {

        // Call the API
        return API.getJson(Constants.URL + "/customer_rewards/getallcustomer_rewards");    }
}
