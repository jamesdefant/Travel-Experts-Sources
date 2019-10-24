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

import dbAccess.ProductSupplierDb;
import model.ProductSupplier;



@Path("/productsupplier")
public class ProductSupplierRestService {

  // http://localhost:8080/TravelExperts/rs/productsupplier/getallproductsuppliers
  @GET
  @Path("/getallproductsuppliers")
  @Produces(MediaType.APPLICATION_JSON)
  public String getProductSuppliers() {
  	  
	  return GenericREST.getJson(ProductSupplierDb.getProductSupplierList(), new TypeToken<List<ProductSupplier>>() {}.getType());	
  }
  
  // http://localhost:8080/TravelExperts/rs/productsupplier/getproductsupplier/3
  @GET
  @Path("/getproductsupplier/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getProductSupplier(@PathParam("id") int Id) {
  
	  return GenericREST.getJson(ProductSupplierDb.getProductSupplier(Id), ProductSupplier.class);	 
  }
  
  // http://localhost:8080/TravelExperts/rs/productsupplier/updateproductsupplier
  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
  @POST
  @Path("/updateproductsupplier")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String updateProductSupplier(String jsonString) {
  
      Type type = new TypeToken<List<ProductSupplier>>() {}.getType();	 
	  Gson gson = new Gson();
	  ArrayList<ProductSupplier> list = gson.fromJson(jsonString, type);

	  
	  // Pass the values to the database
	  if(ProductSupplierDb.updateProductSupplier(list.get(0), list.get(1))) {
		  return "ProductSupplier UPDATE sucessful";
	  } else {
		  return "ProductSupplier UPDATE failed";
	  }
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/productsupplier/insertproductsupplier
  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
  @PUT
  @Path("/insertproductsupplier")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String insertProductSupplier(String jsonString) {
  
	  // Create an object from the JSON
	  Gson gson = new Gson();
	  ProductSupplier obj = gson.fromJson(jsonString, ProductSupplier.class);
	  
	  int rows = ProductSupplierDb.addProductSupplier(obj);
	  
	  return GenericREST.getMsg("ProductSupplier", "INSERT", rows);
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/productsupplier/deleteproductsupplier/3
  @DELETE
  @Path("/deleteproductsupplier/{id}")
  public String deleteProductSupplier(@PathParam("id") int Id) {
  
	  String msg = "";
  
	  int rows = ProductSupplierDb.deleteProductSupplier(Id);
	  
	  return GenericREST.getMsg("ProductSupplier", "DELETE", rows);
	  
  }
}