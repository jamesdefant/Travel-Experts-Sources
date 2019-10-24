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

import dbAccess.ProductDb;
import model.Product;




@Path("/product")
public class ProductRestService {

  // http://localhost:8080/TravelExperts/rs/product/getallproducts
  @GET
  @Path("/getallproducts")
  @Produces(MediaType.APPLICATION_JSON)
  public String getProducts() {
  	  
	  return GenericREST.getJson(ProductDb.getProductList(), new TypeToken<List<Product>>() {}.getType());	
  }
  
  // http://localhost:8080/TravelExperts/rs/product/getproduct/3
  @GET
  @Path("/getproduct/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getProduct(@PathParam("id") int Id) {
  
	  return GenericREST.getJson(ProductDb.getProduct(Id), Product.class);	 
  }
  
  // http://localhost:8080/TravelExperts/rs/product/updateproduct
  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
  @POST
  @Path("/updateproduct")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String updateProduct(String jsonString) {
  
      Type type = new TypeToken<List<Product>>() {}.getType();	 
	  Gson gson = new Gson();
	  ArrayList<Product> list = gson.fromJson(jsonString, type);

	  
	  // Pass the values to the database
	  if(ProductDb.updateProduct(list.get(0), list.get(1))) {
		  return "Product UPDATE sucessful";
	  } else {
		  return "Product UPDATE failed";
	  }
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/product/insertproduct
  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
  @PUT
  @Path("/insertproduct")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String insertProduct(String jsonString) {
  
	  // Create an object from the JSON
	  Gson gson = new Gson();
	  Product obj = gson.fromJson(jsonString, Product.class);
	  
	  int rows = ProductDb.addProduct(obj);
	  
	  return GenericREST.getMsg("Product", "INSERT", rows);
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/product/deleteproduct/3
  @DELETE
  @Path("/deleteproduct/{id}")
  public String deleteProduct(@PathParam("id") int Id) {
  
	  String msg = "";
  
	  int rows = ProductDb.deleteProduct(Id);
	  
	  return GenericREST.getMsg("Agent", "DELETE", rows);
	  
  }
}