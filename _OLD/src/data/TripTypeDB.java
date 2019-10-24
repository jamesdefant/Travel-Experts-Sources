package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.TripType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TripTypeDB {

    private Gson gson;
    private TripTypeData data;

    // Constructor
    public TripTypeDB(TripTypeData data) {

        this.data = data;
    }

    /**
     * Retrieve TripType Json and return TripType object
     * @param strId - id of the TripType
     * @return TripType object
     */
    public TripType getTripType(String strId) {

        gson = new Gson();
        String jsonData = this.data.getTripType(strId);
        System.out.println("jsonData: " + jsonData);
        return gson.fromJson(jsonData, TripType.class);

    }

    /**
     * Retrieve TripTypeList json and return ArrayList<TripType> object
     * @return list of all TripType in database
     */
    public ArrayList<TripType> getTripTypeList() {

        gson = new Gson();
        String jsonData = this.data.getTripTypes();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<TripType>>() {}.getType();
        return gson.fromJson(jsonData, type);
    }
//
//    /**
//     * INSERT a new Package_Product_Supplier in the database
//     * @param package_Product_Supplier to insert
//     * @return message of success/failure
//     */
//    public String insertTripType(TripTypeData tripType) {
//
//        gson = new Gson();
//        String jsonData = gson.toJson(package_Product_Supplier, TripTypeData.class);
//        String response = this.data.insertPackage_Product_Supplier(jsonData);
//        return response;
//    }
//
//    /**
//     * UPDATE a Package_Product_Supplier in the database
//     * @param oldPackage_Product_Supplier to check for optimistic concurrency
//     * @param newPackage_Product_Supplier to update
//     * @return message of success/failure
//     */
//    public String updatePackage_Product_Supplier(Package_Product_Supplier oldPackage_Product_Supplier,
//                                                 Package_Product_Supplier newPackage_Product_Supplier) {
//
//        gson = new Gson();
//        ArrayList<TripTypeData> list = new ArrayList<>();
//        list.add(oldPackage_Product_Supplier);
//        list.add(newPackage_Product_Supplier);
//        Type type = new TypeToken<List<TripTypeData>>() {}.getType();
//
//        String jsonData = gson.toJson(list, type);
//        String response = this.data.updatePackage_Product_Supplier(jsonData);
//        return response;
//    }
//
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
//
//    public String deleteCustomer(int customerId) {
//
//        return this.customerData.deleteCustomer(customerId);
//    }

}
