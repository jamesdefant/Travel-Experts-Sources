package data.dummy;

public class AgentData implements data.AgentData {

    @Override
    public String getAgent(int agentId) {
        return "{\"agentId\":1,\"agencyId\":1,\"agtBusPhone\":\"(403) 210-7801\",\"agtEmail\":\"janet.delton@travelexperts.com\",\"agtFirstName\":\"Janet\",\"agtLastName\":\"Delton\",\"agtPosition\":\"Senior Agent\"}";
    }

    @Override
    public String getAllAgents() {
        return "[{\"agentId\":1,\"agencyId\":1,\"agtBusPhone\":\"(403) 210-7801\",\"agtEmail\":\"janet.delton@travelexperts.com\",\"agtFirstName\":\"Janet\",\"agtLastName\":\"Delton\",\"agtPosition\":\"Senior Agent\"},{\"agentId\":2,\"agencyId\":1,\"agtBusPhone\":\"(403) 210-7802\",\"agtEmail\":\"judy.lisle@travelexperts.com\",\"agtFirstName\":\"Judy\",\"agtLastName\":\"Lisle\",\"agtPosition\":\"Intermediate Agent\"},{\"agentId\":3,\"agencyId\":1,\"agtBusPhone\":\"(403) 210-7843\",\"agtEmail\":\"dennis.reynolds@travelexperts.com\",\"agtFirstName\":\"Dennis\",\"agtLastName\":\"Reynolds\",\"agtMiddleInitial\":\"C.\",\"agtPosition\":\"Junior Agent\"},{\"agentId\":4,\"agencyId\":1,\"agtBusPhone\":\"(403) 210-7823\",\"agtEmail\":\"john.coville@travelexperts.com\",\"agtFirstName\":\"John\",\"agtLastName\":\"Coville\",\"agtPosition\":\"Intermediate Agent\"},{\"agentId\":5,\"agencyId\":2,\"agtBusPhone\":\"(403) 210-5555\",\"agtEmail\":\"fred@travelexperts.com\",\"agtFirstName\":\"Fred\",\"agtLastName\":\"Smith\",\"agtMiddleInitial\":\"J\",\"agtPosition\":\"Junior Agent\"},{\"agentId\":6,\"agencyId\":2,\"agtBusPhone\":\"(403) 210-7867\",\"agtEmail\":\"bruce.dixon@travelexperts.com\",\"agtFirstName\":\"Bruce\",\"agtLastName\":\"Dixon\",\"agtMiddleInitial\":\"J.\",\"agtPosition\":\"Intermediate Agent\"},{\"agentId\":7,\"agencyId\":1,\"agtBusPhone\":\"(403) 210-7812\",\"agtEmail\":\"beverly.jones@travelexperts.com\",\"agtFirstName\":\"Beverly\",\"agtLastName\":\"Jones\",\"agtMiddleInitial\":\"S.\",\"agtPosition\":\"Intermediate Agent\"},{\"agentId\":8,\"agencyId\":2,\"agtBusPhone\":\"(403) 210-7868\",\"agtEmail\":\"jane.merrill@travelexperts.com\",\"agtFirstName\":\"Jane\",\"agtLastName\":\"Merrill\",\"agtPosition\":\"Senior Agent\"},{\"agentId\":9,\"agencyId\":2,\"agtBusPhone\":\"(403) 210-7833\",\"agtEmail\":\"brian.peterson@travelexperts.com\",\"agtFirstName\":\"Brian\",\"agtLastName\":\"Peterson\",\"agtMiddleInitial\":\"S.\",\"agtPosition\":\"Junior Agent\"}]";
    }

    @Override
    public String insertAgent(String jsonData) {
        return "INSERT on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String updateAgent(String jsonData) {
        return "UPDATE on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String deleteAgent(int agentId) {
        return "DELETE on " + agentId + "\n...attemtped.\nMethod not yet implemented";
    }
}
