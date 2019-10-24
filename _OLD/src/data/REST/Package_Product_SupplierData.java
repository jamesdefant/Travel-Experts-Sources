package data.REST;

import rest.API;

public class Package_Product_SupplierData implements data.Package_Product_SupplierData {
    @Override
    public String getAllPackage_Product_Suppliers() {

        // Call the API
        return API.getJson(Constants.URL + "/package_product_supplier/getallpackage_product_suppliers");
    }

    @Override
    public String insertPackage_Product_Supplier(String jsonData) {

        // Call the API
        return API.putJson(Constants.URL + "/package_product_supplier/insertpackage_product_supplier", jsonData);
    }

    @Override
    public String updatePackage_Product_Supplier(String jsonData) {

        // Send data to the API and return message
        return API.postJson(Constants.URL + "/package_product_supplier/updatepackage_product_supplier", jsonData);
    }

    @Override
    public String deletePackage_Product_Supplier(int packageId, int product_SupplierId) {

        // Send data to the API and return message
        return API.deleteJson(Constants.URL + "/package_product_supplier/deletepackage_product_supplier/" + packageId + "/" + product_SupplierId);
    }
}
