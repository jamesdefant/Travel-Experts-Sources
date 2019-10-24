
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
import dbAccess.AgentDb;


@Path("/agent")
public class AgentRestService {

  // http://localhost:8080/TravelExperts/rs/agent/getallagents
  @GET
  @Path("/getallagents")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAgents() {
  	  
	  return GenericREST.getJson(AgentDb.getAgentList(), new TypeToken<List<Agent>>() {}.getType());	
  }
  
  // http://localhost:8080/TravelExperts/rs/agent/getagent/3
  @GET
  @Path("/getagent/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAgent(@PathParam("id") int Id) {
  
	  return GenericREST.getJson(AgentDb.getAgent(Id), Agent.class);	 
  }
  
  // http://localhost:8080/TravelExperts/rs/agent/postagent
  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
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
  
  // http://localhost:8080/TravelExperts/rs/agent/insertagent
  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
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
  
  // http://localhost:8080/TravelExperts/rs/agent/deleteagent/3
  @DELETE
  @Path("/deleteagent/{id}")
  public String deleteAgent(@PathParam("id") int Id) {
  
	  String msg = "";
  
	  int rows = AgentDb.deleteAgent(Id);
	  
	  return GenericREST.getMsg("Agent", "DELETE", rows);
	  
  }
}