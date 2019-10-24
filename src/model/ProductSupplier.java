/**
 * Entity class to hold data for 1 row in travelexperts.products_suppliers table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 * Author: Salah Hadj Cherif
 * Date: Oct 12 2019
 */



package model;

public class ProductSupplier {
    private int ProductSupplierId ;
	private Integer	ProductId	;  //nullable
	private Integer	SupplierId ; //nullable


    public ProductSupplier(int productSupplierId, Integer productId, Integer supplierId) {
        ProductSupplierId = productSupplierId;
        ProductId = productId;
        SupplierId = supplierId;
    }

    public int getProductSupplierId() {
        return ProductSupplierId;
    }

    public void setProductSupplierId(int productSupplierId) {
        ProductSupplierId = productSupplierId;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public Integer getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(Integer supplierId) {
        SupplierId = supplierId;
    }

    @Override
    public String toString() {
        return "ProductSupplier{" +
                "ProductSupplierId=" + ProductSupplierId +
                ", ProductId=" + ProductId +
                ", SupplierId=" + SupplierId +
                '}';
    }

  //copy supplierproduct
  public void copy(ProductSupplier prodsupplier)
  {

      ProductSupplierId = prodsupplier.ProductSupplierId;
      ProductId = prodsupplier.ProductId;
      SupplierId = prodsupplier.SupplierId;

  }
}
