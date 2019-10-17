/**
 * Database access class to manipulate travelexperts.products_suppliers table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */


package travelexperts;

import java.sql.*;
import java.util.ArrayList;

public class ProductSupplierDb {
    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts

    /**
     * Method to return all the productsupplier in the products_suppliers table
     *
     * @return List of  productsupplier
     */

    public static ArrayList<ProductSupplier> getProductSupplierList()
    {
        ArrayList<ProductSupplier> listProductSupplier = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM products_suppliers";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {

                int productsupplierId = rs.getInt(1);
                Integer productId = rs.getInt(2);
                if (rs.wasNull())
                    productId=null;
                Integer supplierId = rs.getInt(3);
                if (rs.wasNull())
                    supplierId=null;
                ProductSupplier newProdSupplier = new ProductSupplier( productsupplierId, productId,  supplierId);

                // Add the newproductsupplier to the list
                listProductSupplier.add(newProdSupplier  );
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

        return listProductSupplier;
    }


    /**
     * Method to update a single productsupplier in the products_suppliers table
     * @param newProductSupplier ,oldProductSupplier
     * @return true if success , false if not
     */
    public static boolean updateProductSupplier(ProductSupplier oldProductSupplier , ProductSupplier newProductSupplier) {

        boolean isSuccess = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "UPDATE products_suppliers " +
                    " SET ProductId = ? , SupplierId =? " +
                    " WHERE ProductSupplierId = ? " ;


            // Create a Prepared Statement object
            stmt = conn.prepareStatement(sql);

            //Assign values
            stmt.setInt(1, newProductSupplier.getProductId());
            stmt.setInt(2, newProductSupplier.getSupplierId());
            stmt.setInt(3, oldProductSupplier.getProductSupplierId());

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
     * Method to delete a single ProductSupplier from the products_Suppliers table
     * @param productSupplierId
     * @return 0 if not deleted , 1 if deleted
     */

    public static int deleteProductSupplier(int productSupplierId)
    {
        int rows=0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "DELETE FROM products_suppliers WHERE  ProductSupplierId= ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, productSupplierId);
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
     * Method to add a single ProductSupplier to the ProductSupplier table
     * @param newProductSupplier
     * @return 0 if not inserted , 1 if inserted
     */

    public static int addProductSupplier(ProductSupplier newProductSupplier)
    {
        int rows = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql =
                    " INSERT INTO products_suppliers (  ProductId ,SupplierId) " +
                            " VALUES (? ,?) ";

            stmt =conn.prepareStatement(sql);
            //Assign values
            if (newProductSupplier.getProductId() != null)
            stmt.setInt(1, newProductSupplier.getProductId());
            else
                stmt.setNull(1,Types.INTEGER );
            if (newProductSupplier.getSupplierId() != null)

                stmt.setInt(2,newProductSupplier.getSupplierId() );
            else
                stmt.setNull(2,Types.INTEGER );

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
     * Method to get a single ProductSupplier from the ProductSupplier list
     * @param idprodsup
     * @return a productsupplier
     */

    public static ProductSupplier getProductSupplier(int idprodsup)
    {
        ArrayList<ProductSupplier>  listProductSupplier =getProductSupplierList();
        ProductSupplier productSupplier_result=null;
        for (ProductSupplier productsupplier : listProductSupplier
        ) {
            if (productsupplier.getProductSupplierId() ==idprodsup    ) {
                productSupplier_result = productsupplier;
                break;
            }

        }
        return productSupplier_result;
    }


}
