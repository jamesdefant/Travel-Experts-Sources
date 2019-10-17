/**
 * Database access class to manipulate travelexperts.agency table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */

package travelexperts;

import java.sql.*;
import java.util.ArrayList;

public class AgencyDb {
    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts

    public static ArrayList<Agency> getAgencyList()
    {
        ArrayList<Agency> listAgency = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM agencies";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {

                int agencyId = rs.getInt(1);
                String agncyAddress = rs.getString(2);
                String agncyCity = rs.getString(3);
                String agncyProv = rs.getString(4);
                String agncyPostal = rs.getString(5);
                String agncyCountry = rs.getString(6);
                String agncyPhone = rs.getString(7);
                String  agncyFax=  rs.getString(8);

                Agency newAgency= new Agency( agencyId,  agncyAddress, agncyCity, agncyProv,
                        agncyPostal,  agncyCountry,  agncyPhone,  agncyFax);

                // Add the newcustomer to the list
                listAgency.add(newAgency  );
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

        return listAgency;
    }

    /**
     * Method to get a single Agency from the Agency list
     * @param idAgency
     * @return an agency
     */

    public static Agency getAgency(int idAgency )
    {
        ArrayList<Agency>  listAgency= getAgencyList();
        Agency agencyResult=null;
        for (Agency agency : listAgency
        ) {
            if (agency.getAgencyId() ==idAgency    ) {
                agencyResult = agency;
                break;
            }

        }
        return agencyResult;
    }
}
