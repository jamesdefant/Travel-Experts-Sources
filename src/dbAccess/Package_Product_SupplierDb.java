/**
 * Database access class to manipulate travelexperts.packages_products_suppliers table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */

package dbAccess;

import model.Package_Product_Supplier;
import model.ProductSupplier;

import java.sql.*;
import java.util.ArrayList;


public class Package_Product_SupplierDb {

    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts

    /**
     * Method to return all the productsupplier in the products_suppliers table
     *
     * @return List of  productsupplier
     */

    public static ArrayList<Package_Product_Supplier> getPackageProductSupplierList()
    {
        ArrayList<Package_Product_Supplier> listPackageProductSupplier = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM packages_products_suppliers";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {

                int packageId = rs.getInt(1);
                int productsupplierId = rs.getInt(2);

                Package_Product_Supplier newPkgProdSupplier = new Package_Product_Supplier( packageId, productsupplierId);

                // Add the newproductsupplier to the list
                listPackageProductSupplier.add(newPkgProdSupplier);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Close the objects
            try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return listPackageProductSupplier;
    }

    /**
     * Method to update a single packageproductsupplier in the packages_products_suppliers table
     * @param newPackageProductSupplier ,oldPackageProductSupplier
     * @return true if success , false if not
     */
    public static boolean updatePackageProductSupplier(Package_Product_Supplier  oldPackageProductSupplier ,
                                                       Package_Product_Supplier newPackageProductSupplier) {

        boolean isSuccess = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "UPDATE packages_products_suppliers " +
                    " SET PackageId=?, ProductSupplierId=? " +
                    " WHERE PackageId = ? and ProductSupplierId=? " ;


            // Create a Prepared Statement object
            stmt = conn.prepareStatement(sql);

            //Assign values
            stmt.setInt(1, newPackageProductSupplier.getPackageId());
            stmt.setInt(2, newPackageProductSupplier.getProductSupplierId());
            stmt.setInt(3, oldPackageProductSupplier.getPackageId());
            stmt.setInt(4, oldPackageProductSupplier.getProductSupplierId());


            // Execute the statement
            int rows = stmt.executeUpdate();

            // Check if it was successful
            if(rows == 0) {
                isSuccess = false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Close the objects
            try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return isSuccess;
    }

    /**
     * Method to delete a single PackageProductSupplier from the packages_products_Suppliers table
     * @param packageId, productSupplierId
     * @return 0 if not deleted , 1 if deleted
     */

    public static int deletePackageProductSupplier(int packageId , int productSupplierId)
    {
        int rows=0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "DELETE FROM packages_products_suppliers WHERE  packageId=  ? AND ProductSupplierId= ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, packageId);
            stmt.setInt(2, productSupplierId);

            // execute the preparedstatement
            rows= stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Close the objects
            try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return rows;
    }

    /**
     * Method to add a single PackageProductSupplier to the packages_products_suppliers table
     * @param newPackageProductSupplier
     * @return 0 if not inserted , 1 if inserted
     */

    public static int addPackageProductSupplier(Package_Product_Supplier newPackageProductSupplier)
    {
        int rows = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql =
                    " INSERT INTO packages_products_suppliers (  PackageId, ProductSupplierId ) " +
                            " VALUES (? ,?) ";

            stmt =conn.prepareStatement(sql);
            //Assign values

                stmt.setInt(1, newPackageProductSupplier.getPackageId());
                stmt.setInt(2,newPackageProductSupplier.getProductSupplierId() );

            // Execute the statement
            rows = stmt.executeUpdate();
            //this will add an id to our new agent added to the table

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Close the objects
            try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return rows;
    }

    /**
     * Method to get a single PackageProductSupplier from the PackageProductSupplier list
     * @param PkgId
     * @return a list of productsupplier
     */

    //get all prodSup of PackagId
    public static ArrayList<ProductSupplier> getListProdSupplierOfPkgID(int PkgId)
    {
        ArrayList <Package_Product_Supplier>  lstPkgProdSupp= getPackageProductSupplierList();
        ArrayList<ProductSupplier> lstresult=new ArrayList<>() ;
        ProductSupplier prodsupp = null;
        for  (Package_Product_Supplier pkgProdsupp : lstPkgProdSupp)
        {
            if (pkgProdsupp.getPackageId() == PkgId)
            {
                //get productSupplier of pkgProdSupp.ProductSupplier
                prodsupp = ProductSupplierDb.getProductSupplier(pkgProdsupp.getProductSupplierId());
                //add this ProductSupplier to the result list
                lstresult.add(prodsupp);
            }

        }
        return lstresult;
    }

}
