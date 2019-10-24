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

import dbAccess.PackageDb;
import model.Package;



@Path("/package")
public class PackageRestService {

  // http://localhost:8080/TravelExperts/rs/package/getallpackages
  @GET
  @Path("/getallpackages")
  @Produces(MediaType.APPLICATION_JSON)
  public String getPackages() {
  	  
	  ArrayList<model.Package> list =  PackageDb.getPackageList();
	
		String jsonString = "[";
			
		boolean isFirst = true; 
		
		for(model.Package pkg : list) {
			System.out.println("obj: " + pkg);
			
		    Gson gson = new Gson();
		    Type type = new TypeToken<model.Package>() {}.getType();
		    
		    if(isFirst) {
		    	isFirst = false;
				jsonString +=  gson.toJson(pkg, type);
		    }
		    jsonString +=  ",";
			jsonString +=  gson.toJson(pkg, type);
			
		}
		jsonString +=  "]";	
		
		return jsonString;

//	  return GenericREST.getJson(PackageDb.getPackageList(), new TypeToken<List<Package>>() {}.getType());	
  }
  
  // http://localhost:8080/TravelExperts/rs/package/getpackage/3
  @GET
  @Path("/getpackage/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getPackage(@PathParam("id") int Id) {
  
	  return GenericREST.getJson(PackageDb.getPackage(Id), Package.class);
  }
  
  // http://localhost:8080/TravelExperts/rs/package/updatepackage
  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
  @POST
  @Path("/updatepackage")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String updatePackage(String jsonString) {
  
      Type type = new TypeToken<List<Package>>() {}.getType();	 
	  Gson gson = new Gson();
	  ArrayList<Package> list = gson.fromJson(jsonString, type);

	  
	  // Pass the values to the database
	  if(PackageDb.updatePackage(list.get(0), list.get(1))) {
		  return "Package UPDATE sucessful";
	  } else {
		  return "Package UPDATE failed";
	  }
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/package/insertpackage
  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
  @PUT
  @Path("/insertpackage")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String insertPackage(String jsonString) {
  
	  // Create an object from the JSON
	  Gson gson = new Gson();
	  model.Package obj = gson.fromJson(jsonString, model.Package.class);
	  
	  int rows = PackageDb.addPackage(obj);
	  
	  return GenericREST.getMsg("Package", "INSERT", rows);
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/package/deletepackage/3
  @DELETE
  @Path("/deletepackage/{id}")
  public String deletePackage(@PathParam("id") int Id) {
  
	  String msg = "";
  
	  int rows = PackageDb.deletePackage(Id);
	  
	  return GenericREST.getMsg("Package", "DELETE", rows);
	  
  }
}