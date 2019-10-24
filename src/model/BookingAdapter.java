package model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class BookingAdapter extends TypeAdapter<Booking> {

	final private DateFormat SIMPLE_FORMAT = new SimpleDateFormat("yyyy-MM-dd"); 
	
	@Override
	public Booking read(JsonReader in) throws IOException {


		
		int BookingId = 0;
		Date BookingDate = null;
        String	BookingNo = null;
        Double	TravelerCount = null;
        Integer	CustomerId = null;
        String TripTypeId = null;
        Integer PackageId = null;
        
        
		// Read the opening curly-brace
		in.beginObject();
		
		// Loop through the tokens
		while(in.hasNext()) {
			
			switch(in.nextName()) {
			
			case "BookingId":
				BookingId = in.nextInt();
				break;
				
			case "BookingDate":
				try {
				BookingDate = SIMPLE_FORMAT.parse(in.nextString());
				} catch(ParseException e) {
					e.printStackTrace();
				}
				break;
				
			case "BookingNo":
				BookingNo = in.nextString();
				break;
			
			case "TravelerCount":
				TravelerCount = in.nextDouble();
				break;
				
			case "CustomerId":
				CustomerId = in.nextInt();
				break;
				
			case "TripTypeId":
				TripTypeId = in.nextString();
				break;
				
			case "PackageId":
				PackageId = in.nextInt();
				break;
			}
		}
		
		// Create a new object
		Booking booking = new Booking(BookingId, BookingDate, BookingNo, TravelerCount,
				CustomerId, TripTypeId, PackageId);
		
		// Read the closing curly-brace
		in.endObject();
		
		// Return the object
		return booking;
	}

	@Override
	public void write(JsonWriter out, Booking booking) throws IOException {
		
		// Write an open curly-brace to the JSON
		out.beginObject();
					
		// Write the object to JSON in name:value pairs 
		out.name("BookingId").value(booking.getBookingId());
		
		// Check for nulls
		if(booking.getBookingDate() != null) {

			String date = SIMPLE_FORMAT.format(booking.getBookingDate());
			out.name("BookingDate").value(date);
		}
		
		if(booking.getBookingNo() != null) {
			out.name("BookingNo").value(booking.getBookingNo());
		}
		if(booking.getTravelerCount() != null) {
			out.name("TravelerCount").value(booking.getTravelerCount());
		}
		if(booking.getCustomerId() != null) {
			out.name("CustomerId").value(booking.getCustomerId());
		}
		if(booking.getTripTypeId() != null) {
			out.name("TripTypeId").value(booking.getTripTypeId());
		}
		if(booking.getPackageId() != null) {
			out.name("PackageId").value(booking.getPackageId());
		}		
		
		// Write a closed curly-brace to the JSON
		out.endObject();
		out.close();	
		
	}

}
