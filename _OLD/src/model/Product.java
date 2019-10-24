/**
 * Entity class to hold data for 1 row in travelexperts.products table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 * Author: Salah Hadj Cherif
 * Date: Oct 12 2019
 */


package model;

public class Product {
    private int ProductId;
    String ProdName;

    public Product(int productId, String prodName) {
        ProductId = productId;
        ProdName = prodName;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String prodName) {
        ProdName = prodName;
    }
    //copy product
    public void copy(Product product)
    {

        ProductId = product.getProductId();
        ProdName = product.getProdName();

    }
    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", ProdName='" + ProdName + '\'' +
                '}';
    }
}
