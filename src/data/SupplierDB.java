package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Supplier;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SupplierDB {

    private Gson gson;
    private SupplierData data;

    // Constructor
    public SupplierDB(SupplierData data) {

        this.data = data;
    }

    /**
     * Retrieve Supplier Json and return Supplier object
     * @param supplierId - id of the Supplier
     * @return Supplier object
     */
    public Supplier getSupplier(int supplierId) {

        gson = new Gson();
        String jsonData = this.data.getSupplier(supplierId);
        System.out.println("jsonData: " + jsonData);
        return gson.fromJson(jsonData, Supplier.class);

    }

    /**
     * Retrieve SupplierList json and return ArrayList<Supplier> object
     * @return list of all Suppliers in database
     */
    public ArrayList<Supplier> getSupplierList() {

        gson = new Gson();
        String jsonData = this.data.getAllSuppliers();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<Supplier>>() {}.getType();
        return gson.fromJson(jsonData, type);
    }

    /**
     * INSERT a new Supplier in the database
     * @param supplier to insert
     * @return message of success/failure
     */
    public String insertSupplier(Supplier supplier) {



        gson = new Gson();
        String jsonData = gson.toJson(supplier, Supplier.class);
        String response = this.data.insertSupplier(jsonData);
        return response;
    }


    /**
     * UPDATE an Supplier in the database
     * @param oldSupplier to check for optimistic concurrency
     * @param newSupplier to update
     * @return message of success/failure
     */
    public String updateSupplier(Supplier oldSupplier, Supplier newSupplier) {

        gson = new Gson();
        ArrayList<Supplier> list = new ArrayList<>();
        list.add(oldSupplier);
        list.add(newSupplier);
        Type type = new TypeToken<List<Supplier>>() {}.getType();

        String jsonData = gson.toJson(list, type);
        String response = this.data.updateSupplier(jsonData);
        return response;
    }

    /**
     * DELETE an Supplier in the database
     * @param supplierId of Supplier to delete
     * @return message of success/failure
     */
    public String deleteSupplier(int supplierId) {

        return this.data.deleteSupplier(supplierId);
    }
}
