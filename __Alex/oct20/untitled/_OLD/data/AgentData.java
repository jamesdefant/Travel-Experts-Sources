package data;

public interface AgentData {

    String getAgent(int agentId);
    String getAllAgents();
    String insertAgent(String jsonData);
    String updateAgent(String jsonData);
    String deleteAgent(int agentId);
}
