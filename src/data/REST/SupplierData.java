package data.REST;

import rest.API;

public class SupplierData implements data.SupplierData {
    @Override
    public String getSupplier(int supplierId) {

        // Call the API
        return API.getJson(Constants.URL + "/supplier/getsupplier/" + supplierId);
    }

    @Override
    public String getAllSuppliers() {

        // Call the API
        return API.getJson(Constants.URL + "/supplier/getallsuppliers");
    }

    @Override
    public String insertSupplier(String jsonData) {

        // Send data to the API and return message
        return API.putJson(Constants.URL + "/supplier/insertsupplier", jsonData);
    }

    @Override
    public String updateSupplier(String jsonData) {

        // Send data to the API and return message
        return API.postJson(Constants.URL + "/supplier/updatesupplier", jsonData);
    }

    @Override
    public String deleteSupplier(int supplierId) {

        // Send data to the API and return message
        return API.deleteJson(Constants.URL + "/supplier/deletesupplier/" + supplierId);
    }
}
