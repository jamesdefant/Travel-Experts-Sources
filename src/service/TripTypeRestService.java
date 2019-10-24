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

import model.TripType;
import dbAccess.TripTypeDb;




@Path("/triptype")
public class TripTypeRestService {

  // http://localhost:8080/TravelExperts/rs/triptype/getalltriptypes
  @GET
  @Path("/getalltriptypes")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllTriptypes() {
  	  
	  return GenericREST.getJson(
			  TripTypeDb.getTripTypesList(), 
			  new TypeToken<List<TripType>>() {}.getType()
			  );	
  }
  
  // http://localhost:8080/TravelExperts/rs/triptype/gettriptype/B
  @GET
  @Path("/gettriptype/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getTriptype(@PathParam("id") String strId) {
  
	  return GenericREST.getJson(
			  TripTypeDb.getTripTypeByid(strId), 
			  TripType.class
			  );	 
  }
/*  
  // http://localhost:8080/TravelExperts/rs/triptype/postagent
  @POST
  @Path("/updateagent")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String updateAgent(String jsonString) {
  
      Type type = new TypeToken<List<Agent>>() {}.getType();	 
	  Gson gson = new Gson();
	  ArrayList<Agent> list = gson.fromJson(jsonString, type);

	  
	  // Pass the values to the database
	  if(AgentDb.updateAgent(list.get(0), list.get(1))) {
		  return "Agent UPDATE sucessful";
	  } else {
		  return "Agent UPDATE failed";
	  }
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/triptype/insertagent
  @PUT
  @Path("/insertagent")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String insertAgent(String jsonString) {
  
	  // Create an object from the JSON
	  Gson gson = new Gson();
	  Agent obj = gson.fromJson(jsonString, Agent.class);
	  
	  int rows = AgentDb.addAgent(obj);
	  
	  return GenericREST.getMsg("Agent", "INSERT", rows);
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/triptype/deleteagent/3
  @DELETE
  @Path("/deleteagent/{id}")
  public String deleteAgent(@PathParam("id") int Id) {
  
	  String msg = "";
  
	  int rows = AgentDb.deleteAgent(Id);
	  
	  return GenericREST.getMsg("Agent", "DELETE", rows);
	  
  }
*/
}