package data;

public interface ProductSupplierData {

    String getProductSupplier(int productSupplierId);
    String getAllProductSuppliers();
    String insertProductSupplier(String jsonData);
    String updateProductSupplier(String jsonData);
    String deleteProductSupplier(int productSupplierId);
}
