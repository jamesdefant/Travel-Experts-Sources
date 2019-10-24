package data.REST;

import rest.API;

public class ProductData implements data.ProductData {
    @Override
    public String getProduct(int productId) {

        // Call the API
        return API.getJson(Constants.URL + "/product/getproduct/" + productId);    }

    @Override
    public String getAllProducts() {

        // Call the API
        return API.getJson(Constants.URL + "/product/getallproducts");    }

    @Override
    public String insertProduct(String jsonData) {

        // Send data to the API and return message
        return API.putJson(Constants.URL + "/product/insertproduct", jsonData);    }

    @Override
    public String updateProduct(String jsonData) {

        // Send data to the API and return message
        return API.postJson(Constants.URL + "/product/updateproduct", jsonData);    }

    @Override
    public String deleteProduct(int productId) {

        // Send data to the API and return message
        return API.deleteJson(Constants.URL + "/product/deleteproduct/" + productId);    }
}
