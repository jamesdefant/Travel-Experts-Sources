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

import dbAccess.RewardDb;
import model.Reward;


@Path("/reward")
public class RewardRestService {

  // http://localhost:8080/TravelExperts/rs/reward/getallrewards
  @GET
  @Path("/getallrewards")
  @Produces(MediaType.APPLICATION_JSON)
  public String getRewards() {
  	  
	  Type type = new TypeToken<List<Reward>>() {}.getType();
	  ArrayList<Reward> obj = RewardDb.getRewardList();
	  Gson gson = new Gson();
	  return gson.toJson(obj, type);
	  
  }
  
  // http://localhost:8080/TravelExperts/rs/reward/getreward/3
  @GET
  @Path("/getreward/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getReward(@PathParam("id") int Id) {
  
	  return GenericREST.getJson(RewardDb.getRewardByid(Id), Reward.class);	 
  }
  
//  // http://localhost:8080/TravelExperts/rs/reward/postagent
//  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
//  @POST
//  @Path("/updateagent")
//  @Produces(MediaType.TEXT_PLAIN)
//  @Consumes(MediaType.APPLICATION_JSON)
//  public String updateReward(String jsonString) {
//  
//      Type type = new TypeToken<List<Reward>>() {}.getType();	 
//	  Gson gson = new Gson();
//	  ArrayList<Reward> list = gson.fromJson(jsonString, type);
//
//	  
//	  // Pass the values to the database
//	  if(RewardDb.updateReward(list.get(0), list.get(1))) {
//		  return "Agent UPDATE sucessful";
//	  } else {
//		  return "Agent UPDATE failed";
//	  }
//	  
//  }
//  
//  // http://localhost:8080/TravelExperts/rs/reward/insertagent
//  // {"AgtFirstName":"Joe", "AgtLastName":"Bob"}
//  @PUT
//  @Path("/insertagent")
//  @Produces(MediaType.TEXT_PLAIN)
//  @Consumes(MediaType.APPLICATION_JSON)
//  public String insertAgent(String jsonString) {
//  
//	  // Create an object from the JSON
//	  Gson gson = new Gson();
//	  Agent obj = gson.fromJson(jsonString, Agent.class);
//	  
//	  int rows = AgentDb.addAgent(obj);
//	  
//	  return GenericREST.getMsg("Agent", "INSERT", rows);
//	  
//  }
//  
//  // http://localhost:8080/TravelExperts/rs/reward/deleteagent/3
//  @DELETE
//  @Path("/deleteagent/{id}")
//  public String deleteAgent(@PathParam("id") int Id) {
//  
//	  String msg = "";
//  
//	  int rows = AgentDb.deleteAgent(Id);
//	  
//	  return GenericREST.getMsg("Agent", "DELETE", rows);
//	  
//  }
}