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


import model.Package_Product_Supplier;
import dbAccess.Package_Product_SupplierDb;


@Path("/package_product_supplier")
public class Package_Product_SupplierRestService {

  // http://localhost:8080/TravelExperts/rs/package_product_supplier/getallpackage_product_suppliers
  @GET
  @Path("/getallpackage_product_suppliers")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllPackage_Product_Supplies() {  
	  
	  return GenericREST.getJson(Package_Product_SupplierDb.getPackageProductSupplierList(), new TypeToken<List<Package_Product_Supplier>>() {}.getType());	

  }
  
  // http://localhost:8080/TravelExperts/rs/package_product_supplier/getpackage_product_supplier/3
  @GET
  @Path("/getpackage_product_supplier/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getPackage_Product_Supplier(@PathParam("id") int Id) {
  
//	  Package_Product_Supplier obj = Package_Product_SupplierDb.g
//	  Gson gson = new Gson();
//	  return gson.toJson(obj, Package_Product_Supplier.class);
	  return "Not yet implemented";
  }
  
  // http://localhost:8080/TravelExperts/rs/package_product_supplier/updatepackage_product_supplier
  @POST
  @Path("/updatepackage_product_supplier")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String updatePackage_Product_Supplier(String jsonString) {
  
      Type type = new TypeToken<List<Package_Product_Supplier>>() {}.getType();	 
	  Gson gson = new Gson();
	  ArrayList<Package_Product_Supplier> list = gson.fromJson(jsonString, type);

	  
	  // Pass the values to the database
	  if(Package_Product_SupplierDb.updatePackageProductSupplier(list.get(0), list.get(1))) {
		  return "Package_Product_Supplier UPDATE sucessful";
	  } else {
		  return "Package_Product_Supplier UPDATE failed";
	  }
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/package_product_supplier/insertpackage_product_supplier
  @PUT
  @Path("/insertpackage_product_supplier")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String insertPackage_Product_Supplier(String jsonString) {
  
	  // Create an object from the JSON
	  Gson gson = new Gson();
	  Package_Product_Supplier obj = gson.fromJson(jsonString, Package_Product_Supplier.class);
	  
	  int rows = Package_Product_SupplierDb.addPackageProductSupplier(obj);
	  
//	  // Get the data from the database   
//	  if(Package_Product_SupplierDb.addPackageProductSupplier(obj) == 1) {
//		  return "Package_Product_Supplier INSERT successful";
//	  }	else {
//		  return "Package_Product_Supplier INSERT failed";
//	  }
	  
	  return GenericREST.getMsg("Package_Product_Supplier", "INSERT", rows);
  }
  
  // http://localhost:8080/TravelExperts/rs/package_product_supplier/deletepackage_product_supplier/3
  @DELETE
  @Path("/deletepackage_product_supplier/{packageid}/{product_supplierid}")
  public String deleteAgent(@PathParam("packageid") int packageId, @PathParam("product_supplierid") int product_supplierId) {
  
	  String msg = "";
  
	  int rows = Package_Product_SupplierDb.deletePackageProductSupplier(packageId, product_supplierId);

	  return GenericREST.getMsg("Package_Product_Supplier", "DELETE", rows);
//	  if(rows <= 0) {
//		  msg = "Problem deleting package_product_supplier";
//	  } else if(rows == 1) {
//		  msg = "Package_product_supplier deleted";
//	  } else {
//		  msg = "Many package_product_suppliers deleted";
//	  }
//    
//	  msg += " - # of rows affected: " + rows;
//	  return msg;
  }
}