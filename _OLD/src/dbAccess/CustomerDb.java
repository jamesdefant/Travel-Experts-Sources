/**
 * Database access class to manipulate travelexperts.customer table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */

package dbAccess;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;



public class CustomerDb {

    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts

    public static ArrayList<Customer> getCustomerList()
    {
        ArrayList<Customer> listCustomer = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM customers";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {
                int customerId = rs.getInt(1);
                String custFirstName = rs.getString(2);
                String custLastName = rs.getString(3);
                String custAddress = rs.getString(4);
                String custCity = rs.getString(5);
                String custProv = rs.getString(6);
                String custPostal = rs.getString(7);

                String custCountry = rs.getString(8);    // nullable
                if(rs.wasNull())
                    custCountry = null;

                String custHomePhone = rs.getString(9);   // nullable
                if(rs.wasNull())
                    custHomePhone = null;

                String custBusPhone = rs.getString(10);
                String custEmail = rs.getString(11);

                Integer custAgentId = rs.getInt(12);//nullable
                if(rs.wasNull())
                    custAgentId = null;

                String custusername = rs.getString(13);
                if(rs.wasNull())
                    custusername = null;

                String custpassword = rs.getString(14);
                if(rs.wasNull())
                    custpassword = null;

                Customer newCustomer= new   Customer( customerId,custFirstName, custLastName,
                        custAddress, custCity,  custProv, custPostal, custCountry,
                        custHomePhone,  custBusPhone,  custEmail,  custAgentId, custusername,  custpassword);

                // Add the newcustomer to the list
                listCustomer.add(newCustomer);
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

        return listCustomer;
    }

    /**
     * Method to update a single Customer in the customers table
     * @param newCustomer ,oldCustomer
     * @return true if success , false if not
     */
    public static boolean updateCustomer(Customer oldCutomer , Customer newCustomer) {

        boolean isSuccess = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "UPDATE customers SET CustFirstName = ?, CustLastName = ?, " +
                    " CustAddress = ? , CustCity = ? , " +
                    " CustProv= ? , CustPostal = ? , " +
                    " CustCountry= ? , CustHomePhone = ? , " +
                    " CustBusPhone = ? , " +
                    " CustEmail = ? , " +
                    " AgentId = ? ,  " +
                    " Custusername =? , Custpassword=?  " +
                    "   WHERE (CustomerId = ? AND " +
                    " CustFirstName = ? AND CustLastName = ? AND " +
                    " CustAddress = ? AND CustCity = ? AND " +
                    " CustProv= ? AND CustPostal = ? AND " +
                    " (CustCountry= ? or (CustCountry is Null AND ? is NULL) )  AND (CustHomePhone = ? OR (CustHomePhone is NULL AND ? is NULL)) AND " +
                    " CustBusPhone = ? AND " +
                    " CustEmail = ? AND " +
                    " (AgentId = ?  OR (AgentId is Null AND ? is NULL )) AND " +
                    " Custusername = ? AND Custpassword= ? ) ";

            // Create a Prepared Statement object
            stmt = conn.prepareStatement(sql);

            //Assign values
            stmt.setString(1, newCustomer.getCustFirstName());
            stmt.setString(2, newCustomer.getCustLastName());
            stmt.setString(3, newCustomer.getCustAddress());
            stmt.setString(4, newCustomer.getCustCity());
            stmt.setString(5, newCustomer.getCustProv());
            stmt.setString(6, newCustomer.getCustPostal());
            stmt.setString(7, newCustomer.getCustCountry());
            stmt.setString(8, newCustomer.getCustHomePhone());
            stmt.setString(9, newCustomer.getCustBusPhone());
            stmt.setString(10, newCustomer.getCustEmail());

            if (newCustomer.getAgentId() != null)
                stmt.setInt(11, newCustomer.getAgentId());
            else stmt.setString(11,null);

            stmt.setString(12, newCustomer.getCustusername());
            stmt.setString(13, newCustomer.getCustpassword());
            stmt.setInt(14, oldCutomer.getCustomerId());
            //Check for optimistic concurrancy
            stmt.setString(15, oldCutomer.getCustFirstName());
            stmt.setString(16, oldCutomer.getCustLastName());
            stmt.setString(17, oldCutomer.getCustAddress());
            stmt.setString(18, oldCutomer.getCustCity());
            stmt.setString(19, oldCutomer.getCustProv());
            stmt.setString(20, oldCutomer.getCustPostal());
            stmt.setString(21, oldCutomer.getCustCountry());
            stmt.setString(22, oldCutomer.getCustCountry());

            stmt.setString(23, oldCutomer.getCustHomePhone());
            stmt.setString(24, oldCutomer.getCustHomePhone());
            stmt.setString(25, oldCutomer.getCustBusPhone());
            stmt.setString(26, oldCutomer.getCustEmail());

            if (oldCutomer.getAgentId() != null) {
                stmt.setInt(27, oldCutomer.getAgentId());
                stmt.setInt(28, oldCutomer.getAgentId());
            }
                else {
                stmt.setString(27, null);
                stmt.setString(28 ,null);
                }

                stmt.setString(29, oldCutomer.getCustusername());
                stmt.setString(30, oldCutomer.getCustpassword());

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
     * Method to delete a single Customer from the Customer table
     * @param customerId
     * @return 0 if not deleted , 1 if deleted
     */

    public static int deleteCustmer(int customerId)
    {
        //we make sure to delete all the bookings related to this customer before we deleted we
        //will do that in the upper level while we have to look for all the bookings for this customer and
        //run a small method that delete all his bookings from the bookings table before deleting the actual customer
        int rows=0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "DELETE FROM customers WHERE CustomerId = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customerId);
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
     * Method to add a single Customer to the Customer table
     * @param newCustomer
     * @return 0 if not inserted , 1 if inserted
     */

    public static int addCustomer(Customer newCustomer)
    {
        int rows = 1;

        Connection conn = null;
        PreparedStatement stmt = null;
        String insertstmt;
        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "INSERT INTO customers ( CustFirstName , CustLastName ," +
                    " CustAddress  ,CustCity  , " +
                    " CustProv , CustPostal  , " +
                    " CustCountry , CustHomePhone  , " +
                    " CustBusPhone  , " +
                    " CustEmail  , AgentId  ,  " +
                    "Custusername  , Custpassword)  " +
                    " VALUES ( ? , ? ," +
                    " ?  ,?  , " +
                    " ? , ?  , " +
                    " ? , ?  , " +
                    " ?  , " +
                    " ?  ," ;
            if (newCustomer.getAgentId()!=null)
            insertstmt = " ?  ,  ";
            else
                insertstmt =" null, ";
            sql= sql +insertstmt;

            sql=sql +        "?  , ? ) ";
            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1 , newCustomer.getCustFirstName());
            stmt.setString(2, newCustomer.getCustLastName());
            stmt.setString(3, newCustomer.getCustAddress());
            stmt.setString(4, newCustomer.getCustCity());
            stmt.setString(5, newCustomer.getCustProv());
            stmt.setString(6, newCustomer.getCustPostal());
            stmt.setString(7, newCustomer.getCustCountry());
            stmt.setString(8, newCustomer.getCustHomePhone());
            stmt.setString(9, newCustomer.getCustBusPhone());
            stmt.setString(10, newCustomer.getCustEmail());

            if (newCustomer.getAgentId() != null) {
                stmt.setInt(11, newCustomer.getAgentId());
                stmt.setString(12, newCustomer.getCustusername());
                stmt.setString(13, newCustomer.getCustpassword());
            }
            else
            {
                stmt.setString(11, newCustomer.getCustusername());
                stmt.setString(12, newCustomer.getCustpassword());

            }
            // Execute the statement
            rows = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            //this will add an id to the new customer created in table
            if (rs.next()){
                int newCustId=rs.getInt(1);
                newCustomer.setCustomerId(newCustId);
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

        return rows;

    }

    /**
     * Method to get a single Customer from the Customer list
     * @param idCustomer
     * @return a customer
     */

    public static Customer getCustomer(int idCustomer)
    {
        ArrayList<Customer>  listCustomer =getCustomerList();
        Customer customerResult=null;
        for (Customer customer : listCustomer
             ) {
            if (customer.getCustomerId() ==idCustomer) {
                customerResult = customer;
                break;
            }

        }
        return customerResult;
    }

}
