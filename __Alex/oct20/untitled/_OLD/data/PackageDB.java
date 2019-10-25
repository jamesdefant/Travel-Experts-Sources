package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PackageDB {

    private Gson gson;
    private PackageData data;

    // Constructor
    public PackageDB(PackageData data) {

        this.data = data;
    }

    /**
     * Retrieve Package Json and return Package object
     * @param package_Product_SupplierId - id of the Package
     * @return Package object
     */
//    public Package getPackage_Product_Supplier(int package_Product_SupplierId) {
//
//        gson = new Gson();
//        String jsonData = this.data.getCustomer(package_Product_SupplierId);
//        System.out.println("jsonData: " + jsonData);
//        return gson.fromJson(jsonData, Package_Product_Supplier.class);
//
//    }

    /**
     * Retrieve Package list json and return ArrayList<Package> object
     * @return list of all Package in database
     */
    public ArrayList<Package> getPackageList() {

        gson = new Gson();
        String jsonData = this.data.getAllPackages();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<Package>>() {}.getType();
        return gson.fromJson(jsonData, type);
    }

//    /**
//     * INSERT a new Package_Product_Supplier in the database
//     * @param package_Product_Supplier to insert
//     * @return message of success/failure
//     */
//    public String insertPackage_Product_Supplier(Package_Product_Supplier package_Product_Supplier) {
//
//        gson = new Gson();
//        String jsonData = gson.toJson(package_Product_Supplier, Package_Product_Supplier.class);
//        String response = this.data.insertPackage_Product_Supplier(jsonData);
//        return response;
//    }

    /**
     * UPDATE a Package in the database
     * @param oldPackage to check for optimistic concurrency
     * @param newPackage to update
     * @return message of success/failure
     */
    public String updatePackage(Package oldPackage,
                                Package newPackage) {

        gson = new Gson();
        ArrayList<Package> list = new ArrayList<>();
        list.add(oldPackage);
        list.add(newPackage);
        Type type = new TypeToken<List<Package>>() {}.getType();

        String jsonData = gson.toJson(list, type);
        String response = this.data.updatePackage(jsonData);
        return response;
    }

//    /**
//     * DELETE an Package_Product_Supplier in the database
//     * @param packageId of Package_Product_Supplier to delete
//     * @param product_SupplierId of Package_Product_Supplier to delete
//     * @return message of success/failure
//     */
//    public String deletePackage_Product_Supplier(int packageId, int product_SupplierId) {
//
//        return this.data.deletePackage_Product_Supplier(packageId, product_SupplierId);
//    }

}
