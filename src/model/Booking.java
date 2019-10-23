/**
 * Entity class to hold data for 1 row in travelexperts.bookings table
 * Course: CMPP-264 - Java
 * Assignment: workshop 6
 * Author: Salah Hadj Cherif
 * Date: Oct 12 2019
 */


package model;

import java.util.Date;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(BookingAdapter.class)
public class Booking {
		private int BookingId;
		private Date BookingDate ;
        private  String	BookingNo	;
        private Double	TravelerCount;
        private Integer	CustomerId;
        private String TripTypeId	;
        private	Integer PackageId;

    public Booking(int bookingId, Date bookingDate, String bookingNo, Double travelerCount,
                   Integer customerId, String tripTypeId, Integer packageId) {
        BookingId = bookingId;
        BookingDate = bookingDate;
        BookingNo = bookingNo;
        TravelerCount = travelerCount;
        CustomerId = customerId;
        TripTypeId = tripTypeId;
        PackageId = packageId;
    }

    public int getBookingId() {
        return BookingId;
    }

    public void setBookingId(int bookingId) {
        BookingId = bookingId;
    }

    public Date getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        BookingDate = bookingDate;
    }

    public String getBookingNo() {
        return BookingNo;
    }

    public void setBookingNo(String bookingNo) {
        BookingNo = bookingNo;
    }

    public Double getTravelerCount() {
        return TravelerCount;
    }

    public void setTravelerCount(Double travelerCount) {
        TravelerCount = travelerCount;
    }

    public Integer getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Integer customerId) {
        CustomerId = customerId;
    }

    public String getTripTypeId() {
        return TripTypeId;
    }

    public void setTripTypeId(String tripTypeId) {
        TripTypeId = tripTypeId;
    }

    public Integer getPackageId() {
        return PackageId;
    }

    public void setPackageId(Integer packageId) {
        PackageId = packageId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "BookingId=" + BookingId +
                ", BookingDate=" + BookingDate +
                ", BookingNo='" + BookingNo + '\'' +
                ", TravelerCount=" + TravelerCount +
                ", CustomerId=" + CustomerId +
                ", TripTypeId='" + TripTypeId + '\'' +
                ", PackageId=" + PackageId +
                '}';
    }
}
