package data;

public interface SupplierData {

    String getSupplier(int supplierId);
    String getAllSuppliers();
    String insertSupplier(String jsonData);
    String updateSupplier(String jsonData);
    String deleteSupplier(int supplierId);
}
