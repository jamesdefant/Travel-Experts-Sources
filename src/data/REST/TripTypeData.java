package data.REST;

import rest.API;

public class TripTypeData implements data.TripTypeData {
    @Override
    public String getTripType(String tripTypeId) {

        // Call the API
        return API.getJson(Constants.URL + "/triptype/gettriptype/" + tripTypeId);    }

    @Override
    public String getTripTypes() {

        // Call the API
        return API.getJson(Constants.URL + "/triptype/getalltriptypes");    }
}
