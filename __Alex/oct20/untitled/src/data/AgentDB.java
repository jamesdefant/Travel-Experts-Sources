package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Agent;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AgentDB {

    private Gson gson;
    private AgentData data;

    // Constructor
    public AgentDB(AgentData data) {

        this.data = data;
    }

    /**
     * Retrieve Agent Json and return Agent object
     * @param agentId - id of the Agent
     * @return Agent object
     */
    public Agent getAgent(int agentId) {

        gson = new Gson();
        String jsonData = this.data.getAgent(agentId);
        System.out.println("jsonData: " + jsonData);
        return gson.fromJson(jsonData, Agent.class);

    }

    /**
     * Retrieve AgentList json and return ArrayList<Agent> object
     * @return list of all agents in database
     */
    public ArrayList<Agent> getAgentList() {

        gson = new Gson();
        String jsonData = this.data.getAllAgents();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<Agent>>() {}.getType();
        return gson.fromJson(jsonData, type);
    }

    /**
     * INSERT a new Agent in the database
     * @param agent to insert
     * @return message of success/failure
     */
    public String insertAgent(Agent agent) {

        // AgentId must be 0 for an INSERT to be successful
        agent.setAgentId(0);

        gson = new Gson();
        String jsonData = gson.toJson(agent, Agent.class);
        String response = this.data.insertAgent(jsonData);
        return response;
    }


    /**
     * UPDATE an Agent in the database
     * @param oldAgent to check for optimistic concurrency
     * @param newAgent to update
     * @return message of success/failure
     */
    public String updateAgent(Agent oldAgent, Agent newAgent) {

        gson = new Gson();
        ArrayList<Agent> list = new ArrayList<>();
        list.add(oldAgent);
        list.add(newAgent);
        Type type = new TypeToken<List<Agent>>() {}.getType();

        String jsonData = gson.toJson(list, type);
        String response = this.data.updateAgent(jsonData);
        return response;
    }

    /**
     * DELETE an Agent in the database
     * @param agentId of agent to delete
     * @return message of success/failure
     */
    public String deleteAgent(int agentId) {

        return this.data.deleteAgent(agentId);
    }
}
