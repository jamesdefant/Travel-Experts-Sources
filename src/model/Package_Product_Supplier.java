/**
 * Entity class to hold data for 1 row in travelexperts.packages_products_suppliers table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 * Author: Salah Hadj Cherif
 * Date: Oct 12 2019
 */


package model;


public class Package_Product_Supplier {
    private  int PackageId;
	private int	ProductSupplierId;

    public Package_Product_Supplier(int packageId, int productSupplierId) {
        PackageId = packageId;
        ProductSupplierId = productSupplierId;
    }

    public int getPackageId() {
        return PackageId;
    }

    public void setPackageId(int packageId) {
        PackageId = packageId;
    }

    public int getProductSupplierId() {
        return ProductSupplierId;
    }

    public void setProductSupplierId(int productSupplierId) {
        ProductSupplierId = productSupplierId;
    }

    @Override
    public String toString() {
        return "Package_Product_Supplier{" +
                "PackageId=" + PackageId +
                ", ProductSupplierId=" + ProductSupplierId +
                '}';
    }

    //copy package_product_supplier
    public void copy(Package_Product_Supplier packageprodsupplier)
    {
        PackageId = packageprodsupplier.PackageId ;
        ProductSupplierId = packageprodsupplier.ProductSupplierId;
    }

}
