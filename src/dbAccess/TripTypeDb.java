
/**
 * Database access class to manipulate travelexperts.triptypes table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */

package dbAccess;

import model.TripType;

import java.sql.*;
import java.util.ArrayList;

public class TripTypeDb {


    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts

    public static ArrayList<TripType> getTripTypesList()
    {
        ArrayList<TripType> listTripType = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM triptypes";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {

                String triptypeId = rs.getString(1);
                String ttName = rs.getString(2);

                TripType newtriptype = new  TripType( triptypeId,ttName);

                // Add the newcustomer to the list
                listTripType.add(newtriptype  );
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

        return listTripType;
    }
    /**
     * Method to get a single triptype from a list of triptype
     * @param  idtt
     * @return a TripType object
     */

    public static  TripType  getTripTypeByid(String idtt )
    {
        ArrayList<TripType> TripTypeList =getTripTypesList();
        TripType ttResult=null ;
        for (TripType tt : TripTypeList
        ) {
            if (tt.getTriptypeId().equals(idtt)  ) {
                ttResult = tt;
                break;
            }
        }
        return ttResult;
    }



}
