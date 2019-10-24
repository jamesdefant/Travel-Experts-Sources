
package service;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Agent;
import model.Booking;
import dbAccess.BookingDb;


@Path("/booking")
public class BookingRestService {

  // http://localhost:8080/TravelExperts/rs/booking/getallbookings
  @GET
  @Path("/getallbookings")
  @Produces(MediaType.APPLICATION_JSON)
  public String getBookings() {
  
	  // Get the data from the database
	  ArrayList<Booking> bookingList = BookingDb.getBookingList();
	  
	  String jsonString = "[";
	  
	  boolean isFirst = true; 
		
      for(Booking booking : bookingList) {
		System.out.println("booking: " + booking);
		
	    Gson gson = new Gson();
	    Type type = new TypeToken<Booking>() {}.getType();
	    
	    if(isFirst) {
	    	isFirst = false;
			jsonString +=  gson.toJson(booking, type);
	    }
	    jsonString +=  ",";
		jsonString +=  gson.toJson(booking, type);
		
      }
      jsonString +=  "]";

      return jsonString;
//      Type type = new TypeToken<List<Booking>>() {}.getType();	 
//	  Gson gson = new Gson();
//	  
//	  // Send it across the network as JSON	  
//	  return gson.toJson(bookingList, type); 	 
	  
//	  return GenericREST.getJson(BookingDb.getBookingList(), new TypeToken<List<Booking>>() {}.getType());	

  }
  
  // http://localhost:8080/TravelExperts/rs/booking/getbooking/3
  @GET
  @Path("/getbooking/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getBooking(@PathParam("id") int Id) {
  
	  return GenericREST.getJson(BookingDb.GetBookingById(Id), Booking.class);	
	  
//    return "getbooking " + Id;	
  }
/*  
  // http://localhost:8080/TravelExperts/rs/customer/postagent
  @POST
  @Path("/updatecustomer")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String updateCustomer(String jsonString) {
  
      Type type = new TypeToken<List<Customer>>() {}.getType();	 
	  Gson gson = new Gson();
	  ArrayList<Customer> customerList = gson.fromJson(jsonString, type);

	  
	  // Pass the values to the database
	  if(CustomerDb.updateCustomer(customerList.get(0), customerList.get(1))) {
		  return "Customer UPDATE sucessful";
	  } else {
		  return "Customer UPDATE failed";
	  }
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/customer/insertagent
  @PUT
  @Path("/insertcustomer")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String insertCustomer(String jsonString) {
  
	  // Create an object from the JSON
	  Gson gson = new Gson();
	  Customer customer = gson.fromJson(jsonString, Customer.class);
	  
	  // Get the data from the database  
	  if(CustomerDb.addCustomer(customer) == 1) {
		  return "Customer INSERT successful";
	  }	else {
		  return "Customer INSERT failed";
	  }
  }
  
  // http://localhost:8080/TravelExperts/rs/customer/deleteagent/3
  @DELETE
  @Path("/deletecustomer/{customerid}")
  public String deleteAgent(@PathParam("customerid") int customerId) {
  
  String msg = "Customer " + customerId + " deleted";
  
    return msg;
  }
*/  
}