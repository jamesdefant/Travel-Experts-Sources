
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
import model.Customer;
import dbAccess.AgentDb;
import dbAccess.CustomerDb;


@Path("/customer")
public class CustomerRestService {

  // http://localhost:8080/TravelExperts/rs/customer/getallcustomers
  @GET
  @Path("/getallcustomers")
  @Produces(MediaType.APPLICATION_JSON)
  public String getCustomers() {
  
//	  // Get the data from the database
//	  ArrayList<Customer> customerList = CustomerDb.getCustomerList();
//      Type type = new TypeToken<List<Customer>>() {}.getType();	 
//	  Gson gson = new Gson();
//	  
//	  // Send it across the network as JSON	  
//	  return gson.toJson(customerList, type); 	 
	  return GenericREST.getJson(CustomerDb.getCustomerList(), new TypeToken<List<Customer>>() {}.getType());	
  }
  
  // http://localhost:8080/TravelExperts/rs/customer/getagent/3
  @GET
  @Path("/getcustomer/{customerid}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getCustomer(@PathParam("customerid") int Id) {
  
	  return GenericREST.getJson(CustomerDb.getCustomer(Id), Customer.class);	
  }
  
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
	  
//	  // Get the data from the database  
//	  if(CustomerDb.addCustomer(customer) == 1) {
//		  return "Customer INSERT successful";
//	  }	else {
//		  return "Customer INSERT failed";
//	  }
//	  
	  int rows = CustomerDb.addCustomer(customer);
	  
	  return GenericREST.getMsg("Customer", "INSERT", rows);
  }
  
  // http://localhost:8080/TravelExperts/rs/customer/deleteagent/3
  @DELETE
  @Path("/deletecustomer/{customerid}")
  public String deleteAgent(@PathParam("customerid") int Id) {
  

  String msg = "";
  
  int rows = CustomerDb.deleteCustmer(Id);
  
  return GenericREST.getMsg("Customer", "DELETE", rows);
  }
}