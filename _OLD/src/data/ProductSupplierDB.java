package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.ProductSupplier;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductSupplierDB {


    private Gson gson;
    private ProductSupplierData data;

    // Constructor
    public ProductSupplierDB(ProductSupplierData data) {

        this.data = data;
    }

    /**
     * Retrieve ProductSupplier Json and return ProductSupplier object
     * @param productSupplierId - id of the ProductSupplier
     * @return ProductSupplier object
     */
    public ProductSupplier getProductSupplier(int productSupplierId) {

        gson = new Gson();
        String jsonData = this.data.getProductSupplier(productSupplierId);
        System.out.println("jsonData: " + jsonData);
        return gson.fromJson(jsonData, ProductSupplier.class);

    }

    /**
     * Retrieve ProductSupplierList json and return ArrayList<ProductSupplier> object
     * @return list of all ProductSupplier in database
     */
    public ArrayList<ProductSupplier> getProductSupplierList() {

        gson = new Gson();
        String jsonData = this.data.getAllProductSuppliers();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<ProductSupplier>>() {}.getType();
        return gson.fromJson(jsonData, type);
    }

    /**
     * INSERT a new ProductSupplier in the database
     * @param productSupplier to insert
     * @return message of success/failure
     */
    public String insertProductSupplier(ProductSupplier productSupplier) {

        // ProductSupplierId must be 0 for an INSERT to be successful
        productSupplier.setProductSupplierId(0);

        gson = new Gson();
        String jsonData = gson.toJson(productSupplier, ProductSupplier.class);
        String response = this.data.insertProductSupplier(jsonData);
        return response;
    }


    /**
     * UPDATE an ProductSupplier in the database
     * @param oldProductSupplier to check for optimistic concurrency
     * @param newProductSupplier to update
     * @return message of success/failure
     */
    public String updateProductSupplier(ProductSupplier oldProductSupplier, ProductSupplier newProductSupplier) {

        gson = new Gson();
        ArrayList<ProductSupplier> list = new ArrayList<>();
        list.add(oldProductSupplier);
        list.add(newProductSupplier);
        Type type = new TypeToken<List<ProductSupplier>>() {}.getType();

        String jsonData = gson.toJson(list, type);
        String response = this.data.updateProductSupplier(jsonData);
        return response;
    }

    /**
     * DELETE an ProductSupplier in the database
     * @param productSupplierId of ProductSupplier to delete
     * @return message of success/failure
     */
    public String deleteProductSupplier(int productSupplierId) {

        return this.data.deleteProductSupplier(productSupplierId);
    }
}
