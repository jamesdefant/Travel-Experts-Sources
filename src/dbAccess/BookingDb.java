/**
 * Database access class to manipulate travelexperts.bookings table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */


package dbAccess;
import model.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;


public class BookingDb {
    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts
    public static ArrayList<Booking> getBookingList() {
        ArrayList<Booking> listBookings = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM bookings";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {

                int bookingId = rs.getInt(1);
                Date bookingDate = rs.getDate(2);
                if (rs.wasNull())
                    bookingDate= null;
                String bookingNo = rs.getString(3);
                if (rs.wasNull())
                    bookingNo =null;
                Double travelerCount = rs.getDouble(4);
                if (rs.wasNull())
                    travelerCount=null;
                Integer customerId = rs.getInt(5);
                if (rs.wasNull())
                    customerId=null;
                String tripTypeId = rs.getString(6);
                if (rs.wasNull())
                    tripTypeId =null;
                Integer packageId = rs.getInt(7);
                if (rs.wasNull())
                    packageId =null;

                Booking newBooking = new Booking(bookingId, bookingDate, bookingNo, travelerCount,
                        customerId, tripTypeId, packageId);

                // Add the newcustomer to the list
                listBookings.add(newBooking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the objects
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listBookings;

    }

    /**
     * Method to get list of all the bookings  for a given customerid
     * @param  customerId, listBookings
     * @return a list of Booking
     */


    public static ArrayList<Booking> GetBookingsOfCustomer(int customerId )
    {
        ArrayList <Booking> listAllBookings = getBookingList();
    ArrayList<Booking> BookingsResultList=new ArrayList<Booking>() ;
    for (Booking booking : listAllBookings
    ) {
        if (booking.getCustomerId() ==customerId    ) {
            BookingsResultList.add (booking);
        }
    }
    return BookingsResultList;

    }

    /**
     * Method to get list of all the bookings  for a given id
     * @param  bookingId
     * @return a single Booking
     */


    public static Booking GetBookingById(int bookingId )
    {
        ArrayList <Booking> listAllBookings = getBookingList();
        Booking bookingResult= null;
        for (Booking booking : listAllBookings
        ) {
            if (booking.getBookingId() ==bookingId    ) {
                bookingResult =booking;
                break;
            }
        }
        return bookingResult;

    }






}


