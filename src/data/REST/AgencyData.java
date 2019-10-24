package data.REST;

import rest.API;

public class AgencyData implements data.AgencyData {

    @Override
    public String getAgency(int agencyId) {

        // Call the API
        return API.getJson(Constants.URL + "/agency/getagency/" + agencyId);
    }

    @Override
    public String getAllAgencies() {

        // Call the API
        return API.getJson(Constants.URL + "/agency/getallagencies/");
    }
}
