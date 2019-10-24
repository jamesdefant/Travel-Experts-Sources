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

import dbAccess.SupplierDb;
import model.Supplier;



@Path("/supplier")
public class SupplierRestService {

  // http://localhost:8080/TravelExperts/rs/supplier/getallsuppliers
  @GET
  @Path("/getallsuppliers")
  @Produces(MediaType.APPLICATION_JSON)
  public String getSuppliers() {
  	  
	  return GenericREST.getJson(SupplierDb.getSupplierList(), new TypeToken<List<Supplier>>() {}.getType());	
  }
  
  // http://localhost:8080/TravelExperts/rs/supplier/getsupplier/3
  @GET
  @Path("/getsupplier/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getSupplier(@PathParam("id") int Id) {
  
	  return GenericREST.getJson(SupplierDb.getSupplier(Id), Supplier.class);	 
  }
  
  // http://localhost:8080/TravelExperts/rs/supplier/updatesupplier
  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
  @POST
  @Path("/updatesupplier")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String updateSupplier(String jsonString) {
  
      Type type = new TypeToken<List<Supplier>>() {}.getType();	 
	  Gson gson = new Gson();
	  ArrayList<Supplier> list = gson.fromJson(jsonString, type);

	  
	  // Pass the values to the database
	  if(SupplierDb.updateSupplier(list.get(0), list.get(1))) {
		  return "Supplier UPDATE sucessful";
	  } else {
		  return "Supplier UPDATE failed";
	  }
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/supplier/insertsupplier
  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
  @PUT
  @Path("/insertsupplier")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String insertSupplier(String jsonString) {
  
	  // Create an object from the JSON
	  Gson gson = new Gson();
	  Supplier obj = gson.fromJson(jsonString, Supplier.class);
	  
	  int rows = SupplierDb.addSupplier(obj);
	  
	  return GenericREST.getMsg("Supplier", "INSERT", rows);
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/supplier/deletesupplier/3
  @DELETE
  @Path("/deletesupplier/{id}")
  public String deleteSupplier(@PathParam("id") int Id) {
  
	  String msg = "";
  
	  int rows = SupplierDb.deleteSupplier(Id);
	  
	  return GenericREST.getMsg("Supplier", "DELETE", rows);
	  
  }
}