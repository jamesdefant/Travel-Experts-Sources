/**
 * Entity class to hold data for 1 row in travelexperts.agents table
 * Course: CMPP-264 - Java
 * Assignment: workshop 6
 * Author: Salah Hadj Cherif
 * Date: Oct 12 2019
 */

package model;

public class Agent {
        // Member variables
        private int agentId;
        private String agtFirstName;        // nullable
        private String agtMiddleInitial;    // nullable
        private String agtLastName;         // nullable
        private String agtBusPhone;         // nullable
        private String agtEmail;            // nullable
        private String agtPosition;         // nullable
        private Integer agencyId;           // nullable


    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getAgtFirstName() {
        return agtFirstName;
    }

    public void setAgtFirstName(String agtFirstName) {
        this.agtFirstName = agtFirstName;
    }

    public String getAgtMiddleInitial() {
        return agtMiddleInitial;
    }

    public void setAgtMiddleInitial(String agtMiddleInitial) {
        this.agtMiddleInitial = agtMiddleInitial;
    }

    public String getAgtLastName() {
        return agtLastName;
    }

    public void setAgtLastName(String agtLastName) {
        this.agtLastName = agtLastName;
    }

    public String getAgtBusPhone() {
        return agtBusPhone;
    }

    public void setAgtBusPhone(String agtBusPhone) {
        this.agtBusPhone = agtBusPhone;
    }

    public String getAgtEmail() {
        return agtEmail;
    }

    public void setAgtEmail(String agtEmail) {
        this.agtEmail = agtEmail;
    }

    public String getAgtPosition() {
        return agtPosition;
    }

    public void setAgtPosition(String agtPosition) {
        this.agtPosition = agtPosition;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public Agent(int agentId, String agtFirstName, String agtMiddleInitial, String agtLastName,
                 String agtBusPhone, String agtEmail, String agtPosition, Integer agencyId) {
        this.agentId = agentId;
        this.agtFirstName = agtFirstName;
        this.agtMiddleInitial = agtMiddleInitial;
        this.agtLastName = agtLastName;
        this.agtBusPhone = agtBusPhone;
        this.agtEmail = agtEmail;
        this.agtPosition = agtPosition;
        this.agencyId = agencyId;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentId=" + agentId +
                ", agtFirstName='" + agtFirstName + '\'' +
                ", agtMiddleInitial='" + agtMiddleInitial + '\'' +
                ", agtLastName='" + agtLastName + '\'' +
                ", agtBusPhone='" + agtBusPhone + '\'' +
                ", agtEmail='" + agtEmail + '\'' +
                ", agtPosition='" + agtPosition + '\'' +
                ", agencyId=" + agencyId +
                '}';
    }

    //copy an agent method
    public void copy(Agent agent)
    {
        this.agentId = agent.agentId;
        this.agtFirstName = agent.agtFirstName;
        this.agtMiddleInitial = agent.agtMiddleInitial;
        this.agtLastName = agent.agtLastName;
        this.agtBusPhone = agent.agtBusPhone;
        this.agtEmail = agent.agtEmail;
        this.agtPosition = agent.agtPosition;
        this.agencyId = agent.agencyId;

    }


}
