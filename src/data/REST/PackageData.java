package data.REST;

import rest.API;

public class PackageData implements data.PackageData {
    @Override
    public String getPackage(int packageId) {

        // Call the API
        return API.getJson(Constants.URL + "/package/getpackage/" + packageId);
    }

    @Override
    public String getAllPackages() {

        // Call the API
        return API.getJson(Constants.URL + "/package/getallpackages");    }

    @Override
    public String insertPackage(String jsonData) {

        // Send data to the API and return message
        return API.putJson(Constants.URL + "/package/insertpackage", jsonData);
    }

    @Override
    public String updatePackage(String jsonData) {

        // Send data to the API and return message
        return API.postJson(Constants.URL + "/package/updatepackage", jsonData);    }

    @Override
    public String deletePackage(int packageId) {

        // Send data to the API and return message
        return API.deleteJson(Constants.URL + "/package/deletepackage/" + packageId);
    }
}
