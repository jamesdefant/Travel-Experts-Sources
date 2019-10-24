package data;

public interface CustomerData {

    String getCustomer(int customerId);
    String getAllCustomers();
    String insertCustomer(String jsonData);
    String updateCustomer(String jsonData);
    String deleteCustomer(int customerId);
}
