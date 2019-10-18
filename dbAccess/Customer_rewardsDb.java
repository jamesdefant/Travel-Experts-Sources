/**
 * Database access class to manipulate travelexperts.customer_rewards table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */

package dbAccess;

import model.Customer_rewards;

import java.sql.*;
import java.util.ArrayList;

public class Customer_rewardsDb {

    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts

    public static ArrayList<Customer_rewards> getCustomer_rewardsList()
    {
        ArrayList<Customer_rewards> listCustomer_rewards = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM customers_rewards";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {

                int customerId = rs.getInt(1);
                int rewardId = rs.getInt(2);
                String rwdNumber = rs.getString(3);

                Customer_rewards newCustomer_rewards= new Customer_rewards( customerId,rewardId,rwdNumber);

                // Add the newcustomer to the list
                listCustomer_rewards.add(newCustomer_rewards  );
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

        return listCustomer_rewards;
    }

    /**
     * Method to get a list of  customer_rewards from the Customer_rewards list for a given customer id
     * @param  idcustomer
     * @return a list customer_rewards object
     */

    public static  ArrayList<Customer_rewards>  getCustomer_rewardsForCustomer(int idcustomer )
    {
        ArrayList<Customer_rewards> customer_rewardsList =getCustomer_rewardsList();
        ArrayList<Customer_rewards> customer_rewardsResultList=new ArrayList<Customer_rewards>() ;
        for (Customer_rewards customerRewards : customer_rewardsList
        ) {
            if (customerRewards.getCustomerId() ==idcustomer    ) {
                 customer_rewardsResultList.add (customerRewards);
            }
        }
        return customer_rewardsResultList;
    }



}
