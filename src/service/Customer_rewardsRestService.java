
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

import model.Customer_rewards;
import dbAccess.Customer_rewardsDb;


@Path("/customer_rewards")
public class Customer_rewardsRestService {

  // http://localhost:8080/TravelExperts/rs/customer_rewards/getallcustomer_rewards
  @GET
  @Path("/getallcustomer_rewards")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllCustomer_rewards() {
  
	  // Get the data from the database
	  ArrayList<Customer_rewards> list = Customer_rewardsDb.getCustomer_rewardsList();
      Type type = new TypeToken<List<Customer_rewards>>() {}.getType();	 
	  Gson gson = new Gson();
	  
	  // Send it across the network as JSON	  
	  return gson.toJson(list, type); 	 
  }
  
  // http://localhost:8080/TravelExperts/rs/customer_rewards/getcustomer_rewards/3
  @GET
  @Path("/getcustomer_rewards/{customer_rewardsid}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getCustomer_rewards(@PathParam("customer_rewardsid") int customer_rewardsId) {
  
    return "getcustomer_rewards " + customer_rewardsId;	
  }
/*  
  // http://localhost:8080/TravelExperts/rs/customer_rewards/postagent
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
  
  // http://localhost:8080/TravelExperts/rs/customer_rewards/insertagent
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