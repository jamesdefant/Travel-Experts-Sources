package model;
/**
 * Entity class to hold data for 1 row in travelexperts.customers table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 * Author: Salah Hadj Cherif
 * Date: Oct 12 2019
 */
    public class Customer {
        private int CustomerId;
        private String CustFirstName;
        private String CustLastName;
        private String CustAddress;
        private String CustCity;
        private String CustProv;
        private String CustPostal;
        private String CustCountry;
        private String CustHomePhone;
        private String CustBusPhone;
        private String CustEmail;
        private Integer AgentId ;
        private String Custusername;
        private String Custpassword;
        //properties access method

        public int getCustomerId() {
            return CustomerId;
        }

        public void setCustomerId(int customerId) {
            CustomerId = customerId;
        }

        public String getCustFirstName() {
            return CustFirstName;
        }

        public void setCustFirstName(String custFirstName) {
            CustFirstName = custFirstName;
        }

        public String getCustLastName() {
            return CustLastName;
        }

        public void setCustLastName(String custLastName) {
            CustLastName = custLastName;
        }

        public String getCustAddress() {
            return CustAddress;
        }

        public void setCustAddress(String custAddress) {
            CustAddress = custAddress;
        }

        public String getCustCity() {
            return CustCity;
        }

        public void setCustCity(String custCity) {
            CustCity = custCity;
        }

        public String getCustProv() {
            return CustProv;
        }

        public void setCustProv(String custProv) {
            CustProv = custProv;
        }

        public String getCustPostal() {
            return CustPostal;
        }

        public void setCustPostal(String custPostal) {
            CustPostal = custPostal;
        }

        public String getCustCountry() {
            return CustCountry;
        }

        public void setCustCountry(String custCountry) {
            CustCountry = custCountry;
        }

        public String getCustHomePhone() {
            return CustHomePhone;
        }

        public void setCustHomePhone(String custHomePhone) {
            CustHomePhone = custHomePhone;
        }

        public String getCustBusPhone() {
            return CustBusPhone;
        }

        public void setCustBusPhone(String custBusPhone) {
            CustBusPhone = custBusPhone;
        }

        public String getCustEmail() {
            return CustEmail;
        }

        public void setCustEmail(String custEmail) {
            CustEmail = custEmail;
        }

        public Integer getAgentId() {
            return AgentId;
        }

        public void setAgentId(Integer agentId) {
            AgentId = agentId;
        }

        public String getCustusername() {
            return Custusername;
        }

        public void setCustusername(String custusername) {
            Custusername = custusername;
        }

        public String getCustpassword() {
            return Custpassword;
        }

        public void setCustpassword(String custpassword) {
            Custpassword = custpassword;
        }
        //constructor
        public Customer(int customerId, String custFirstName, String custLastName, String custAddress,
                        String custCity, String custProv, String custPostal, String custCountry,
                        String custHomePhone, String custBusPhone, String custEmail, Integer agentId,
                        String custusername, String custpassword) {
            CustomerId = customerId;
            CustFirstName = custFirstName;
            CustLastName = custLastName;
            CustAddress = custAddress;
            CustCity = custCity;
            CustProv = custProv;
            CustPostal = custPostal;
            CustCountry = custCountry;
            CustHomePhone = custHomePhone;
            CustBusPhone = custBusPhone;
            CustEmail = custEmail;
            AgentId = agentId;
            Custusername = custusername;
            Custpassword = custpassword;
        }

        //copy a customer method
        public void copy(Customer customer)
        {
            CustomerId = customer.CustomerId;
            CustFirstName=customer.CustFirstName;
            CustLastName = customer.CustLastName;
            CustAddress = customer.CustAddress;
            CustCity = customer.CustCity;
            CustProv = customer.CustProv;
            CustPostal = customer.CustPostal;
            CustCountry = customer.CustCountry;
            CustHomePhone = customer.CustHomePhone;
            CustBusPhone = customer.CustBusPhone;
            CustEmail = customer.CustEmail;
            AgentId = customer.AgentId;
            Custusername = customer.Custusername;
            Custpassword = customer.Custpassword;
        }
        //tostring method


    @Override
    public String toString() {
        return "Customer{" +
                "CustomerId=" + CustomerId +
                ", CustFirstName='" + CustFirstName + '\'' +
                ", CustLastName='" + CustLastName + '\'' +
                ", CustAddress='" + CustAddress + '\'' +
                ", CustCity='" + CustCity + '\'' +
                ", CustProv='" + CustProv + '\'' +
                ", CustPostal='" + CustPostal + '\'' +
                ", CustCountry='" + CustCountry + '\'' +
                ", CustHomePhone='" + CustHomePhone + '\'' +
                ", CustBusPhone='" + CustBusPhone + '\'' +
                ", CustEmail='" + CustEmail + '\'' +
                ", AgentId=" + AgentId +
                ", Custusername='" + Custusername + '\'' +
                ", Custpassword='" + Custpassword + '\'' +
                '}';
    }
}

