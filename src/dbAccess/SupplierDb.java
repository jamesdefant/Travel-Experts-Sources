/**
 * Database access class to manipulate travelexperts.suppliers table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */

package dbAccess;


import model.Supplier;

import java.sql.*;
import java.util.ArrayList;


public class SupplierDb {
    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts

    /**
     * Method to return all the product in the suppliers table
     *
     * @return List of suppliers
     */

    public static ArrayList<Supplier> getSupplierList()
    {
        ArrayList<Supplier> listSupplier = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM suppliers";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {

                int supplierId = rs.getInt(1);
                String supName = rs.getString(2);
                if (rs.wasNull())
                    supName=null;
                Supplier newSupplier = new  Supplier( supplierId, supName);

                // Add the newcustomer to the list
                listSupplier.add(newSupplier  );
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

        return listSupplier;
    }

    /**
     * Method to update a single supplier in the suppliers table
     * @param newSupplier ,oldSupplier
     * @return true if success , false if not
     */
    public static boolean updateSupplier(Supplier oldSupplier , Supplier newSupplier) {

        boolean isSuccess = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "UPDATE suppliers " +
                    " SET SupName = ? " +
                    " WHERE (SupplierId = ? AND " +
                    " ( SupName =? OR (SupName IS NULL AND ? IS NULL)) ";

            // Create a Prepared Statement object
            stmt = conn.prepareStatement(sql);

            //Assign values
            stmt.setString(1, newSupplier.getSupName());
            stmt.setInt(2, oldSupplier.getSupplierId());
            stmt.setString(3, oldSupplier.getSupName());
            stmt.setString(4, oldSupplier.getSupName());

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
     * Method to delete a single Supplier from the Suppliers table
     * @param supplierId
     * @return 0 if not deleted , 1 if deleted
     */

    public static int deleteSupplier(int supplierId)
    {
        int rows=0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "DELETE FROM suppliers WHERE  SupplierId= ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, supplierId);
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
     * Method to add a single Supplier to the Supplier table
     * @param newSupplier
     * @return 0 if not inserted , 1 if inserted
     */

    public static int addSupplier(Supplier newSupplier)
    {
        int rows = 0;

        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;


        try{

            // Define your Connection object
            conn = dbconn.createConnection();
            //calculate the max supplier id
            String sqlmaxsupid ="select MAX(SupplierId) + 1  as supid from suppliers" ;
            stmt1 =conn.prepareStatement(sqlmaxsupid);

            // Execute the statement
            ResultSet rs = stmt1.executeQuery(sqlmaxsupid);
            int newSuppid=0;
            if (rs.next())
                newSuppid =rs.getInt(1);

            String sql =
                    " INSERT INTO suppliers (SupplierId, SupName) " +
            " VALUES (? ,?) ";

            stmt2 =conn.prepareStatement(sql);
            //Assign values
            stmt2.setInt(1, newSuppid);
            stmt2.setString(2, newSupplier.getSupName());
            // Execute the statement
            rows = stmt2.executeUpdate();
            //this will add an id to our new agent added to the table

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Close the objects
            try { if(stmt1 != null) stmt1.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(stmt2 != null) stmt2.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return rows;
    }

    /**
     * Method to get a single Supplier from the Supplier list
     * @param   idsup
     * @return a supplier
     */

    public static Supplier getSupplier(int idsup)
    {
        ArrayList<Supplier>  listSupplier =getSupplierList();
        Supplier supplierResult=null;
        for (Supplier supplier : listSupplier
        ) {
            if (supplier.getSupplierId() ==idsup    ) {
                supplierResult = supplier;
                break;
            }

        }
        return supplierResult;
    }




}
