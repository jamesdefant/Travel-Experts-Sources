package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Customer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CustomerDB {

    private Gson gson;
    private CustomerData customerData;

    // Constructor
    public CustomerDB(CustomerData customerData) {

        this.customerData = customerData;
    }

    /**
     * Retrieve Customer Json and return Customer object
     * @param customerId - id of the Customer
     * @return Customer object
     */
    public Customer getCustomer(int customerId) {

        gson = new Gson();
        String jsonData = this.customerData.getCustomer(customerId);
        System.out.println("jsonData: " + jsonData);
        return gson.fromJson(jsonData, Customer.class);

    }

    /**
     * Retrieve CustomerList json and return ArrayList<Customer> object
     * @return list of all Customers in database
     */
    public ArrayList<Customer> getCustomerList() {

        gson = new Gson();
        String jsonData = this.customerData.getAllCustomers();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<Customer>>() {}.getType();
        return gson.fromJson(jsonData, type);
    }

    /**
     * INSERT a new Agent in the database
     * @param customer to insert
     * @return message of success/failure
     */
    public String insertCustomer(Customer customer) {

        // AgentId must be 0 for an INSERT to be successful
        customer.setCustomerId(0);

        gson = new Gson();
        String jsonData = gson.toJson(customer, Customer.class);
        String response = this.customerData.insertCustomer(jsonData);
        return response;
    }

    /**
     * UPDATE a Customer in the database
     * @param oldCustomer to check for optimistic concurrency
     * @param newCustomer to update
     * @return message of success/failure
     */
    public String updateAgent(Customer oldCustomer, Customer newCustomer) {

        gson = new Gson();
        ArrayList<Customer> list = new ArrayList<>();
        list.add(oldCustomer);
        list.add(newCustomer);
        Type type = new TypeToken<List<Customer>>() {}.getType();

        String jsonData = gson.toJson(list, type);
        String response = this.customerData.updateCustomer(jsonData);
        return response;
    }

    /**
     * DELETE an Customer in the database
     * @param customerId of Customer to delete
     * @return message of success/failure
     */
    public String deleteCustomer(int customerId) {

        return this.customerData.deleteCustomer(customerId);
    }

}
