
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

import model.Agency;
import dbAccess.AgencyDb;



@Path("/agency")
public class AgencyRestService {

  // http://localhost:8080/TravelExperts/rs/agency/getallagencies
  @GET
  @Path("/getallagencies")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAgencies() {
  
	  // Get the data from the database
	  ArrayList<Agency> agencyList = AgencyDb.getAgencyList();
      Type type = new TypeToken<List<Agency>>() {}.getType();	 
	  Gson gson = new Gson();
	  
	  // Send it across the network as JSON	  
	  return gson.toJson(agencyList, type); 	 
  }
  
  // http://localhost:8080/TravelExperts/rs/agency/getagent/3
  @GET
  @Path("/getagency/{agencyid}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAgency(@PathParam("agencyid") int agencyId) {
  
	  Agency obj = AgencyDb.getAgency(agencyId);
	  Gson gson = new Gson();
	  return gson.toJson(obj, Agency.class);
//    return "getagent " + agencyId;	
  }
/*  
  // http://localhost:8080/TravelExperts/rs/agent/postagent
  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
  @POST
  @Path("/updateagent")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String updateAgent(String jsonString) {
  
      Type type = new TypeToken<List<Agent>>() {}.getType();	 
	  Gson gson = new Gson();
	  ArrayList<Agent> agentList = gson.fromJson(jsonString, type);

	  
	  // Pass the values to the database
	  if(AgentDb.updateAgent(agentList.get(0), agentList.get(1))) {
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
	  Agent agent = gson.fromJson(jsonString, Agent.class);
	  
	  // Get the data from the database  
	  if(AgentDb.addAgent(agent) == 1) {
		  return "Agent INSERT successful";
	  }	else {
		  return "Agent INSERT failed";
	  }
  }
  
  // http://localhost:8080/TravelExperts/rs/agent/deleteagent/3
  @DELETE
  @Path("/deleteagent/{agentid}")
  public String deleteAgent(@PathParam("agentid") int agentId) {
  
  String msg = "Agent " + agentId + " deleted";
  
    return msg;
  }
*/  
}