/**
 * Database access class to manipulate travelexperts.rewards table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */


package dbAccess;

import model.Reward;


import java.sql.*;
import java.util.ArrayList;

public class RewardDb {

    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts

    public static ArrayList<Reward> getRewardList()
    {
        ArrayList<Reward> listRewards = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM rewards";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {

                int rewardId = rs.getInt(1);
                String rwdName = rs.getString(2);
                String rwdDesc = rs.getString(3);

                Reward newreward = new Reward( rewardId,rwdName,rwdDesc);

                // Add the newcustomer to the list
                listRewards.add(newreward );
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

        return listRewards;
    }

    /**
     * Method to get a single reward from a list of reward
     * @param  idreward
     * @return a reward object
     */

    public static  Reward  getRewardByid(int idreward )
    {
        ArrayList<Reward> RewardList =getRewardList();
        Reward rwdResult=null ;
        for (Reward rwd : RewardList
        ) {
            if (rwd.getRewardId() == idreward  ) {
                rwdResult = rwd;
                break;
            }
        }
        return rwdResult;
    }

}
