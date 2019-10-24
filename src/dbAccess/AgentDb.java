/**
 * Database access class to manipulate travelexperts.agents table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */


package dbAccess;



import model.Agent;

import java.sql.*;
import java.util.ArrayList;


public class AgentDb {
    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts

    public static ArrayList<Agent> getAgentList()
    {
        ArrayList<Agent> listAgent = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM agents";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {

                int agentId = rs.getInt(1);
                String agtFirstName = rs.getString(2);

                String agtMiddleInitial = rs.getString(3);

                String agtLastName = rs.getString(4);

                String agtBusPhone = rs.getString(5);
                String agtEmail = rs.getString(6);
                String agtPosition = rs.getString(7);
                Integer  agencyId =  rs.getInt(8);
                if (rs.wasNull()) agencyId= null ;
                String agtUserId=rs.getString(9);
                String agtPassword=rs.getString(10);

                Agent newAgent= new Agent( agentId, agtFirstName, agtMiddleInitial,agtLastName,
                        agtBusPhone, agtEmail, agtPosition,  agencyId,agtUserId,agtPassword);

                // Add the newcustomer to the list
                listAgent.add(newAgent  );
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

        return listAgent;
    }

    /**
     * Method to update a single Agent in the agents table
     * @param newAgent ,oldAgent
     * @return true if success , false if not
     */
    public static boolean updateAgent(Agent oldAgent , Agent newAgent) {

        boolean isSuccess = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "UPDATE `agents` " +
                    "SET `AgtFirstName` = ?, " +
                    "`AgtMiddleInitial` = ?, " +
                    "`AgtLastName` = ?, " +
                    "`AgtBusPhone` = ?, " +
                    "`AgtEmail` = ?, " +
                    "`AgtPosition` = ?, " +
                    "`AgencyId` = ? ," +
                    "`AgtUserId` = ? ," +
                    "`AgtPassword` = ? " +
                    "WHERE `AgentId` = ? " +
                    "AND (`AgtFirstName` = ? OR " +
                    "( `AgtFirstName` IS NULL AND ? IS NULL))" +
                    "AND (`AgtMiddleInitial` = ? OR " +
                    "(`AgtMiddleInitial` IS NULL AND ? IS NULL))" +
                    "AND (`AgtLastName` = ? OR " +
                    "(`AgtLastName` IS NULL AND ? IS NULL))" +
                    "AND (`AgtBusPhone` = ? OR " +
                    " (`AgtBusPhone` IS NULL AND ? IS NULL))" +
                    "AND (`AgtEmail` = ? OR " +
                    "( `AgtEmail` IS NULL AND ? IS NULL))" +
                    "AND (`AgtPosition` = ? OR " +
                    "(`AgtPosition` IS NULL AND ? IS NULL))" +
                    "AND (`AgencyId` = ? OR " +
                    "(`AgencyId` IS NULL AND ? IS NULL))";

            // Create a Prepared Statement object
            stmt = conn.prepareStatement(sql);

            //Assign values
            stmt.setString(1, newAgent.getAgtFirstName());
            stmt.setString(2, newAgent.getAgtMiddleInitial());
            stmt.setString(3, newAgent.getAgtLastName());
            stmt.setString(4, newAgent.getAgtBusPhone());
            stmt.setString(5, newAgent.getAgtEmail());
            stmt.setString(6, newAgent.getAgtPosition());
            if (newAgent.getAgencyId()!= null)
                stmt.setInt(7, newAgent.getAgencyId());
            else
                stmt.setString(7, null  );
            stmt.setString(8,newAgent.getAgtUserId());
            stmt.setString(9, newAgent.getAgtPassword());

            stmt.setInt(10, oldAgent.getAgentId());
            //Check for optimistic concurrancy

            stmt.setString(11, oldAgent.getAgtFirstName());
            stmt.setString(12, oldAgent.getAgtFirstName());

            stmt.setString(13, oldAgent.getAgtMiddleInitial());
            stmt.setString(14, oldAgent.getAgtMiddleInitial());

            stmt.setString(15, oldAgent.getAgtLastName());
            stmt.setString(16, oldAgent.getAgtLastName());

            stmt.setString(17, oldAgent.getAgtBusPhone());
            stmt.setString(18, oldAgent.getAgtBusPhone());
            stmt.setString(19, oldAgent.getAgtEmail());
            stmt.setString(20, oldAgent.getAgtEmail());
            stmt.setString(21, oldAgent.getAgtPosition());
            stmt.setString(22, oldAgent.getAgtPosition());

            if (oldAgent.getAgencyId()!= null){
                stmt.setInt(23, oldAgent.getAgencyId());
                stmt.setInt(24, oldAgent.getAgencyId());}
            else {
                stmt.setString(23, null);
                stmt.setString(24, null);
            }



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
     * Method to delete a single Agent from the Agent table
     * @param agentid
     * @return 0 if not deleted , 1 if deleted
     */

    public static int deleteAgent(int agentid)
    {
        int rows=0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "DELETE FROM agents WHERE  AgentId= ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, agentid);
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
     * Method to add a single agent to the agents table
     * @param newAgent
     * @return 0 if not inserted , 1 if inserted
     */

    public static int addAgent(Agent newAgent)
    {
        int rows = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "INSERT INTO agents ( AgtFirstName , " +
                    " AgtMiddleInitial , " +
                    " AgtLastName , " +
                    " AgtBusPhone , " +
                    " AgtEmail , " +
                    " AgtPosition , " +
                    " AgencyId ,  " +
                    " AgtUserId ,  " +
                    " AgtPassword )  " +
                    " VALUES ( ? , " +
                    " ?  , " +
                    " ? ,  " +
                    " ? ,  " +
                    " ? ,  " +
                    " ? , " +
                    " ? , "+
                    "?,?)";
            stmt =conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            //Assign values
            stmt.setString(1, newAgent.getAgtFirstName());
            stmt.setString(2, newAgent.getAgtMiddleInitial());
            stmt.setString(3, newAgent.getAgtLastName());
            stmt.setString(4, newAgent.getAgtBusPhone());
            stmt.setString(5, newAgent.getAgtEmail());
            stmt.setString(6, newAgent.getAgtPosition());
            if (newAgent.getAgencyId()!= null)
                stmt.setInt(7, newAgent.getAgencyId());
            else
                stmt.setString(7, null  );

            stmt.setString(8, newAgent.getAgtUserId());
            stmt.setString(9, newAgent.getAgtPassword());

            // Execute the statement
            rows = stmt.executeUpdate();
            //this will add an id to our new agent added to the table
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                int newAgtId=rs.getInt(1);
                newAgent.setAgentId(newAgtId);
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
     * Method to get a single Agent from the Agent list
     * @param idAgent
     * @return an agent
     */

    public static Agent getAgent(int idAgent)
    {
        ArrayList<Agent>  listAgent= getAgentList();
        Agent agentResult=null;
        for (Agent agent : listAgent
        ) {
            if (agent.getAgentId() ==idAgent    ) {
                agentResult = agent;
                break;
            }

        }
        return agentResult;
    }

}
