package data;

public interface ProductData {

    String getProduct(int productId);
    String getAllProducts();
    String insertProduct(String jsonData);
    String updateProduct(String jsonData);
    String deleteProduct(int productId);
}
