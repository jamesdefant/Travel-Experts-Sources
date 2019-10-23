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
                double pkgBasePrice = rs.getDouble(6);
                Double pkgAgencyCommission =rs.getDouble(7);

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
                    "( PkgStartDate IS NULL AND ? IS NULL)) AND " +
                    "(PkgEndDate = ? OR " +
                    "( PkgEndDate IS NULL AND ? IS NULL)) AND " +
                    "(PkgDesc = ? OR " +
                    "( PkgDesc IS NULL AND ? IS NULL)) AND " +
                    " PkgBasePrice = ? AND  " +
                    "(PkgAgencyCommission = ? OR " +
                    "( PkgAgencyCommission IS NULL AND ? IS NULL))" ;

            // Create a Prepared Statement object
            stmt = conn.prepareStatement(sql);

            //Assign values
            stmt.setString(1, newPackage.getPkgName());
            if (newPackage.getPkgStartDate()!=null)
            stmt.setDate(2,  new java.sql.Date( newPackage.getPkgStartDate().getTime()));
            else
                stmt.setNull(2,  Types.DATE);
            if (newPackage.getPkgEndDate()!=null)
            stmt.setDate(3, new java.sql.Date( newPackage.getPkgEndDate().getTime()));
            else
                stmt.setNull(3,  Types.DATE);

            stmt.setString(4, newPackage.getPkgDesc());
            stmt.setDouble(5,newPackage.getPkgBasePrice());
            if (newPackage.getPkgAgencyCommission()!=null)
            stmt.setDouble(6,newPackage.getPkgAgencyCommission());
            else
                stmt.setNull(6,  Types.FLOAT);
            stmt.setInt(7,oldPackage.getPackageId());
            stmt.setString(8,oldPackage.getPkgName());
            if (oldPackage.getPkgStartDate()!=null){
            stmt.setDate(9,new java.sql.Date( oldPackage.getPkgStartDate().getTime()));
            stmt.setDate(10,new java.sql.Date( oldPackage.getPkgStartDate().getTime()));}
            else{
                stmt.setNull(9,Types.DATE);
                stmt.setNull(10,Types.DATE);}


            if (oldPackage.getPkgEndDate()!=null) {
                stmt.setDate(11, new java.sql.Date(oldPackage.getPkgEndDate().getTime()));
                stmt.setDate(12, new java.sql.Date(oldPackage.getPkgEndDate().getTime()));
            }
            else{
                stmt.setNull(11,Types.DATE);
                stmt.setNull(12,Types.DATE);}

            stmt.setString(13,oldPackage.getPkgDesc());
            stmt.setString(14,oldPackage.getPkgDesc());
            stmt.setDouble(15,oldPackage.getPkgBasePrice());
            if (oldPackage.getPkgAgencyCommission()!=null) {
                stmt.setDouble(16, oldPackage.getPkgAgencyCommission());
                stmt.setDouble(17, oldPackage.getPkgAgencyCommission());
            }
            else{
                stmt.setNull(16,Types.FLOAT);
            stmt.setNull(17,Types.FLOAT);}

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
     * Method to delete a single package from the packages table
     * @param packageId
     * @return 0 if not deleted , 1 if deleted
     */

    public static int deletePackage(int packageId)
    {

        int rows=0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "DELETE FROM packages WHERE PackageId = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, packageId);
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
     * Method to add a single Package to the package table
     * @param newPackage
     * @return 0 if not inserted , 1 if inserted
     */
    public static int addPackage(Package newPackage)
    {
        int rows = 1;

        Connection conn = null;
        PreparedStatement stmt = null;
        String insertstmt;
        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "INSERT INTO packages ( PkgName , PkgStartDate ," +
                    " PkgEndDate  ,PkgDesc  , " +
                    " PkgBasePrice , PkgAgencyCommission  ) "+
                    " VALUES ( ? , ? ," +
                    " ?  ,?  , " +
                    " ? , ?  ) "  ;

            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, newPackage.getPkgName());
            stmt.setDate(2, new java.sql.Date( newPackage.getPkgStartDate().getTime()));
            stmt.setDate(3, new java.sql.Date( newPackage.getPkgEndDate().getTime()));
            stmt.setString(4, newPackage.getPkgDesc());
            stmt.setDouble(5,newPackage.getPkgBasePrice());
            stmt.setDouble(6,newPackage.getPkgAgencyCommission());

            // Execute the statement
            rows = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            //this will add an id to the new customer created in table
            if (rs.next()){
                int newPkgId=rs.getInt(1);
                newPackage.setPackageId(newPkgId);
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
     * Method to get a single Package from the Package list
     * @param idPackage
     * @return a package
     */

    public static Package getPackage(int idPackage)
    {
        ArrayList<Package>  listPackage =getPackageList();
        Package pkgResult=null;
        for (Package pkg : listPackage
        ) {
            if (pkg.getPackageId() ==idPackage) {
                pkgResult = pkg;
                break;
            }

        }
        return pkgResult;
    }

}
