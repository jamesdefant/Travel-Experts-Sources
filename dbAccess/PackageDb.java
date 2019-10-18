/**
 * Database access class to manipulate travelexperts.packages table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */

package dbAccess;

import model.Package;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class PackageDb {

    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts

    /**
     * Method to return all the package in the packages table
     *
     * @return List of  packages
     */

    public static ArrayList<Package> getPackageList()
    {
        ArrayList<Package> listPackage = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM packages";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {

                int packageId = rs.getInt(1);
                String pkgName = rs.getString(2);
                Date pkgStartDate=rs.getDate(3);
                Date pkgEndDate=rs.getDate(4);
                String pkgDesc =rs.getString(5);
                float pkgBasePrice = rs.getFloat(6);
                Float pkgAgencyCommission =rs.getFloat(7);

                Package newPackage = new Package( packageId,  pkgName, pkgStartDate, pkgEndDate,  pkgDesc,
                pkgBasePrice, pkgAgencyCommission);

                // Add the newproductsupplier to the list
                listPackage.add(newPackage);
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

        return listPackage;
    }
    /**
     * Method to update a single package in the packages table
     * @param newPackage ,oldPackage
     * @return true if success , false if not
     */
    public static boolean updatePackage(Package  oldPackage , Package newPackage) {

        boolean isSuccess = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql =  "UPDATE Packages SET " +
                    "PkgName = ?, " +
                    "PkgStartDate = ?, " +
                    "PkgEndDate = ?, " +
                    "PkgDesc = ?, " +
                    "PkgBasePrice = ?,  " +
                    "PkgAgencyCommission = ? " +
                    "WHERE PackageID = ? AND " +
                    "PkgName = ? AND " +
                    "(PkgStartDate = ? OR  " +
                    "( PkgStartDate IS NULL AND ? IS NULL))" +
                    "(PkgEndDate = ? OR " +
                    "( PkgEndDate IS NULL AND ? IS NULL))" +
                    "(PkgDesc = ? OR " +
                    "( PkgDesc IS NULL AND ? IS NULL))" +
                    "PkgBasePrice = ? AND " +
                    "(PkgAgencyCommission = ? OR " +
                    "( PkgAgencyCommission IS NULL AND ? IS NULL))" ;

            // Create a Prepared Statement object
            stmt = conn.prepareStatement(sql);

            //Assign values
            stmt.setString(1, newPackage.getPkgName());
            stmt.setDate(2, (java.sql.Date) newPackage.getPkgStartDate());
            stmt.setDate(3, (java.sql.Date) newPackage.getPkgEndDate());
            stmt.setString(4, newPackage.getPkgDesc());
            stmt.setFloat(5,newPackage.getPkgBasePrice());
            stmt.setFloat(6,newPackage.getPkgAgencyCommission());




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






}
