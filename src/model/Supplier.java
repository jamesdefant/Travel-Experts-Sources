/**
 * Entity class to hold data for 1 row in travelexperts.suppliers table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 * Author: Salah Hadj Cherif
 * Date: Oct 12 2019
 */



package model;

public class Supplier {
    private int SupplierId;
	private String	SupName; //nullable


    public Supplier(int supplierId, String supName) {
        SupplierId = supplierId;
        SupName = supName;
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int supplierId) {
        SupplierId = supplierId;
    }

    public String getSupName() {
        return SupName;
    }

    public void setSupName(String supName) {
        SupName = supName;
    }
    //copy supplier
    public void copy(Supplier supplier)
    {

        SupplierId = supplier.getSupplierId();
        SupName = supplier.getSupName();


    }

    @Override
    public String toString() {
        return "Supplier{" +
                "SupplierId=" + SupplierId +
                ", SupName='" + SupName + '\'' +
                '}';
    }
}
