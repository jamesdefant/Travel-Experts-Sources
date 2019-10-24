package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Product;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    private Gson gson;
    private ProductData data;

    // Constructor
    public ProductDB(ProductData data) {

        this.data = data;
    }

    /**
     * Retrieve Product Json and return Product object
     * @param productId - id of the Product
     * @return Product object
     */
    public Product getProduct(int productId) {

        gson = new Gson();
        String jsonData = this.data.getProduct(productId);
        System.out.println("jsonData: " + jsonData);
        return gson.fromJson(jsonData, Product.class);

    }

    /**
     * Retrieve ProductList json and return ArrayList<Product> object
     * @return list of all Products in database
     */
    public ArrayList<Product> getProductList() {

        gson = new Gson();
        String jsonData = this.data.getAllProducts();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<Product>>() {}.getType();
        return gson.fromJson(jsonData, type);
    }

    /**
     * INSERT a new Product in the database
     * @param product to insert
     * @return message of success/failure
     */
    public String insertProduct(Product product) {

        // AgentId must be 0 for an INSERT to be successful
        product.setProductId(0);

        gson = new Gson();
        String jsonData = gson.toJson(product, Product.class);
        String response = this.data.insertProduct(jsonData);
        return response;
    }


    /**
     * UPDATE an Product in the database
     * @param oldProduct to check for optimistic concurrency
     * @param newProduct to update
     * @return message of success/failure
     */
    public String updateProduct(Product oldProduct, Product newProduct) {

        gson = new Gson();
        ArrayList<Product> list = new ArrayList<>();
        list.add(oldProduct);
        list.add(newProduct);
        Type type = new TypeToken<List<Product>>() {}.getType();

        String jsonData = gson.toJson(list, type);
        String response = this.data.updateProduct(jsonData);
        return response;
    }

    /**
     * DELETE an Product in the database
     * @param productId of agent to delete
     * @return message of success/failure
     */
    public String deleteProduct(int productId) {

        return this.data.deleteProduct(productId);
    }
}
