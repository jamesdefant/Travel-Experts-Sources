package data.dummy;

public class Package_Product_SupplierData implements data.Package_Product_SupplierData {
    @Override
    public String getAllPackage_Product_Suppliers() {

        return "[{\"PackageId\":1,\"ProductSupplierId\":65},{\"PackageId\":1,\"ProductSupplierId\":93},{\"PackageId\":2,\"ProductSupplierId\":32},{\"PackageId\":2,\"ProductSupplierId\":33},{\"PackageId\":2,\"ProductSupplierId\":90},{\"PackageId\":3,\"ProductSupplierId\":28},{\"PackageId\":3,\"ProductSupplierId\":82},{\"PackageId\":3,\"ProductSupplierId\":87},{\"PackageId\":4,\"ProductSupplierId\":9},{\"PackageId\":4,\"ProductSupplierId\":65},{\"PackageId\":4,\"ProductSupplierId\":84}]";
    }

    @Override
    public String insertPackage_Product_Supplier(String jsonData) {

        return "INSERT on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String updatePackage_Product_Supplier(String jsonData) {
        return "UPDATE on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String deletePackage_Product_Supplier(int packageId, int product_SupplierId) {
        return "DELETE on \n" + packageId + " / " + product_SupplierId + "\n...attemtped.\nMethod not yet implemented";
    }
}
