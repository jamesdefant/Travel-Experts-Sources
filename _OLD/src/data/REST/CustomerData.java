package data.REST;

import rest.API;

public class CustomerData implements data.CustomerData {

    @Override
    public String getCustomer(int customerId) {

        // Call the API
        return API.getJson(Constants.URL + "/customer/getcustomer/" + customerId);
    }

    @Override
    public String getAllCustomers() {

        // Call the API
        return API.getJson(Constants.URL + "/customer/getallcustomers/");
    }

    @Override
    public String insertCustomer(String jsonData) {

        // Send data to the API and return message
        return API.putJson(Constants.URL + "/customer/insertcustomer", jsonData);
    }

    @Override
    public String updateCustomer(String jsonData) {

        // Send data to the API and return message
        return API.postJson(Constants.URL + "/customer/updatecustomer", jsonData);
    }

    @Override
    public String deleteCustomer(int customerId) {

        // Send data to the API and return message
        return API.deleteJson(Constants.URL + "/customer/deletecustomer/" + customerId);
    }
}
