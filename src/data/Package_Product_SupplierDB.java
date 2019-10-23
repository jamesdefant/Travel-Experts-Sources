package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Package_Product_Supplier;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Package_Product_SupplierDB {

    private Gson gson;
    private Package_Product_SupplierData data;

    // Constructor
    public Package_Product_SupplierDB(Package_Product_SupplierData data) {

        this.data = data;
    }

    /**
     * Retrieve Package_Product_Supplier Json and return Package_Product_Supplier object
     * @param package_Product_SupplierId - id of the Package_Product_Supplier
     * @return Package_Product_Supplier object
     */
//    public Package_Product_Supplier getPackage_Product_Supplier(int package_Product_SupplierId) {
//
//        gson = new Gson();
//        String jsonData = this.data.getCustomer(package_Product_SupplierId);
//        System.out.println("jsonData: " + jsonData);
//        return gson.fromJson(jsonData, Package_Product_Supplier.class);
//
//    }

    /**
     * Retrieve Package_Product_SupplierList json and return ArrayList<Package_Product_Supplier> object
     * @return list of all Package_Product_Suppliers in database
     */
    public ArrayList<Package_Product_Supplier> getPackage_Product_SupplierList() {

        gson = new Gson();
        String jsonData = this.data.getAllPackage_Product_Suppliers();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<Package_Product_Supplier>>() {}.getType();
        return gson.fromJson(jsonData, type);
    }

    /**
     * INSERT a new Package_Product_Supplier in the database
     * @param package_Product_Supplier to insert
     * @return message of success/failure
     */
    public String insertPackage_Product_Supplier(Package_Product_Supplier package_Product_Supplier) {

        gson = new Gson();
        String jsonData = gson.toJson(package_Product_Supplier, Package_Product_Supplier.class);
        String response = this.data.insertPackage_Product_Supplier(jsonData);
        return response;
    }

    /**
     * UPDATE a Package_Product_Supplier in the database
     * @param oldPackage_Product_Supplier to check for optimistic concurrency
     * @param newPackage_Product_Supplier to update
     * @return message of success/failure
     */
    public String updatePackage_Product_Supplier(Package_Product_Supplier oldPackage_Product_Supplier,
                              Package_Product_Supplier newPackage_Product_Supplier) {

        gson = new Gson();
        ArrayList<Package_Product_Supplier> list = new ArrayList<>();
        list.add(oldPackage_Product_Supplier);
        list.add(newPackage_Product_Supplier);
        Type type = new TypeToken<List<Package_Product_Supplier>>() {}.getType();

        String jsonData = gson.toJson(list, type);
        String response = this.data.updatePackage_Product_Supplier(jsonData);
        return response;
    }

    /**
     * DELETE an Package_Product_Supplier in the database
     * @param packageId of Package_Product_Supplier to delete
     * @param product_SupplierId of Package_Product_Supplier to delete
     * @return message of success/failure
     */
    public String deletePackage_Product_Supplier(int packageId, int product_SupplierId) {

        return this.data.deletePackage_Product_Supplier(packageId, product_SupplierId);
    }

}
