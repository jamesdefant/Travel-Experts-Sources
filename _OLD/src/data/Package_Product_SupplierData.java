package data;

public interface Package_Product_SupplierData extends Data {

//    String getPackage_Product_Supplier(int packageId, int product_SupplierId);
    String getAllPackage_Product_Suppliers();
    String insertPackage_Product_Supplier(String jsonData);
    String updatePackage_Product_Supplier(String jsonData);
    String deletePackage_Product_Supplier(int packageId, int product_SupplierId);
}
